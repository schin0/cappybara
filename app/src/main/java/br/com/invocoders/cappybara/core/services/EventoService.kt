package br.com.invocoders.cappybara.core.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import br.com.invocoders.cappybara.viewmodel.EventoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun abrirEvento(navController: NavController, destinoClique: String) {
    navController.navigate(destinoClique)
}

@Composable
fun listarEventosDetalhes(eventoViewModel: EventoViewModel = viewModel()): List<EventoResumo> {
    val eventosDetalhes by eventoViewModel.eventosDetalhes

    LaunchedEffect(Unit) {
        eventoViewModel.listarEventosDetalhes()
    }

    if (eventosDetalhes.isNotEmpty())
        return eventosDetalhes

    return emptyList()
}

@Composable
fun listarEventosProximos(eventoViewModel: EventoViewModel = viewModel()): List<EventoResumo> {
    val eventosProximos by eventoViewModel.eventosProximos
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val localizacaoAtual = withContext(Dispatchers.Main) {
            LocalizacaoService(context).obterLocalizacaoAtual(context)
        }

        localizacaoAtual?.let {
            eventoViewModel.listarEventosProximos(it.latitude, it.longitude)
        }
    }

    if (eventosProximos.isNotEmpty()) {
        return eventosProximos
    }

    return emptyList()
}

@Composable
fun obterEventoDetalhePorId(
    id: Long,
    eventoViewModel: EventoViewModel = viewModel()
): EventoDetalhe {
    val evento by eventoViewModel.eventoDetalhe

    LaunchedEffect(Unit) {
        eventoViewModel.obterEventoDetalhePorId(id)
    }

    return evento
}
