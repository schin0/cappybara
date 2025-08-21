package br.com.invocoders.cappybara.model

data class QuebraGeloRequest(
    val contexto: ContextoQuebraGelo,
    val quantidade: Int,
    val tipoPreferido: Int,
    val nivelDificuldadeMaximo: Int = 0
)

data class ContextoQuebraGelo(
    val localizacao: String,
    val climaAtual: String,
    val horaAtual: Int,
    val diaSemana: String,
    val estacaoAno: String,
    val interessesUsuario: List<String>,
    val culturaLocal: String = ""
)
