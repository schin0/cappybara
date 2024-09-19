package br.com.invocoders.cappybara.core.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import br.com.invocoders.cappybara.viewmodel.EventoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun listarEventosDetalhes(eventoViewModel: EventoViewModel = viewModel()): List<EventoResumo> {
    val eventosDetalhes by eventoViewModel.eventosDetalhes

    LaunchedEffect(Unit) {
        eventoViewModel.listarEventosDetalhes()
    }

    if (eventosDetalhes.isNotEmpty()) return eventosDetalhes

    return emptyList()
}

@Composable
fun listarEventosProximos(
    eventoViewModel: EventoViewModel = viewModel(), itens: Int
): List<EventoResumo> {
    val eventosProximos by eventoViewModel.eventosProximos
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val localizacaoAtual = withContext(Dispatchers.Main) {
            LocalizacaoService(context).obterLocalizacaoAtual(context)
        }

        localizacaoAtual?.let {
            eventoViewModel.listarEventosProximos(it.latitude, it.longitude, itens)
        }
    }

    if (eventosProximos.isNotEmpty()) {
        return eventosProximos
    }

    return emptyList()
}

@Composable
fun obterEventoDetalhePorId(
    id: Long, eventoViewModel: EventoViewModel = viewModel()
): EventoDetalhe {
    val evento by eventoViewModel.eventoDetalhe

    LaunchedEffect(Unit) {
        eventoViewModel.obterEventoDetalhePorId(id)
    }

    return evento
}

@Composable
fun filtrarEventos(
    idCategoria: List<Long>,
    precoInicial: Float,
    precoFinal: Float,
    data: String,
    eventoViewModel: EventoViewModel = viewModel(),
): List<EventoResumo> {
    val eventosFiltrados by eventoViewModel.eventosFiltrados

    LaunchedEffect(Unit) {
        eventoViewModel.filtrarEventos(idCategoria, precoInicial, precoFinal, data)
    }

    if (eventosFiltrados.isNotEmpty()) {
        return eventosFiltrados
    }

    return emptyList()
}