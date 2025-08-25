package br.com.invocoders.cappybara.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.invocoders.cappybara.core.services.gerarIdeiasQuebraGelo
import br.com.invocoders.cappybara.core.utils.ContextoQuebraGeloService
import br.com.invocoders.cappybara.model.ContextoQuebraGelo
import br.com.invocoders.cappybara.model.IdeiaQuebraGelo
import br.com.invocoders.cappybara.model.QuebraGeloRequest
import kotlinx.coroutines.launch

class QuebraGeloViewModel : ViewModel() {
    private val _ideias = mutableStateOf<List<IdeiaQuebraGelo>>(emptyList())
    val ideias: State<List<IdeiaQuebraGelo>> = _ideias
    
    private val _carregando = mutableStateOf(false)
    val carregando: State<Boolean> = _carregando
    
    private val _erro = mutableStateOf<String?>(null)
    val erro: State<String?> = _erro
    
    private val _mensagemMotivacional = mutableStateOf("")
    val mensagemMotivacional: State<String> = _mensagemMotivacional

    init {
        carregarIdeiasIniciais()
    }
    
    fun carregarIdeiasIniciais() {
        _ideias.value = listOf(
            IdeiaQuebraGelo(
                categoria = "Crescimento Pessoal",
                pergunta = "Qual é uma habilidade que você adoraria aprender e por quê?",
                corFundo = "#FF6B9D"
            ),
            IdeiaQuebraGelo(
                categoria = "Viagens",
                pergunta = "Se você pudesse viajar para qualquer lugar do mundo amanhã, para onde iria?",
                corFundo = "#4ECDC4"
            ),
            IdeiaQuebraGelo(
                categoria = "Sonhos",
                pergunta = "Qual é o seu maior sonho que ainda não realizou?",
                corFundo = "#45B7D1"
            )
        )
    }
    
    fun gerarNovasIdeias() {
        viewModelScope.launch {
            _carregando.value = true
            _erro.value = null
            
            val contexto = ContextoQuebraGelo(
                localizacao = ContextoQuebraGeloService.obterLocalizacaoPadrao(),
                climaAtual = ContextoQuebraGeloService.obterClimaAtual(),
                horaAtual = ContextoQuebraGeloService.obterHoraAtual(),
                diaSemana = ContextoQuebraGeloService.obterDiaSemana(),
                estacaoAno = ContextoQuebraGeloService.obterEstacaoAno(),
                interessesUsuario = ContextoQuebraGeloService.obterInteressesUsuario()
            )
            
            val request = QuebraGeloRequest(
                contexto = contexto,
                quantidade = 1,
                tipoPreferido = 0
            )
            
            gerarIdeiasQuebraGelo(
                request = request,
                onSuccess = { resposta ->
                    if (resposta.ideias.isNotEmpty()) {
                        val novaIdeia = resposta.ideias.first()
                        val ideiaQuebraGelo = IdeiaQuebraGelo(
                            categoria = novaIdeia.tags.firstOrNull() ?: "Geral",
                            pergunta = novaIdeia.descricao,
                            corFundo = obterCorAleatoria(),
                            id = novaIdeia.id,
                            titulo = novaIdeia.titulo,
                            descricao = novaIdeia.descricao,
                            tipo = novaIdeia.tipo,
                            tags = novaIdeia.tags,
                            nivelDificuldade = novaIdeia.nivelDificuldade,
                            tempoEstimado = novaIdeia.tempoEstimado
                        )
                        
                        _ideias.value = _ideias.value + ideiaQuebraGelo
                        _mensagemMotivacional.value = resposta.mensagemMotivacional
                    }
                    _carregando.value = false
                },
                onError = { mensagemErro ->
                    _erro.value = mensagemErro
                    _carregando.value = false
                }
            )
        }
    }
    
    private fun obterCorAleatoria(): String {
        val cores = listOf("#FF6B9D", "#4ECDC4", "#45B7D1", "#96CEB4", "#FFEAA7", "#DDA0DD", "#98D8C8")
        return cores.random()
    }
    
    fun limparErro() {
        _erro.value = null
    }
}
