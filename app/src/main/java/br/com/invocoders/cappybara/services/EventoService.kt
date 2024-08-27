package br.com.invocoders.cappybara.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import br.com.invocoders.cappybara.model.Evento
import br.com.invocoders.cappybara.viewmodel.EventoViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun abrirEvento(navController: NavController, destinoClique: String) {
    navController.navigate(destinoClique)
}

fun listarEventos(): List<Evento> {
    return listOf(
        Evento(
            1,
            listOf(R.drawable.user_conf_manage_engine),
            "UserConf - Manage Engine",
            "Vem pra UserConf da Manage Engine! Palestras, workshops, produtos top e network com os feras da área!",
            4.9F,
            LatLng(-23.542582436865693, -46.57684393236166)
        ),
        Evento(
            2,
            listOf(R.drawable.next2023),
            "Next - FIAP - 2024",
            "FIAP reúne galera, empresas e feras da tecnologia pra trocar ideia, aprender e dar aquele up na carreira! Bora?",
            4.8F,
            LatLng(-23.53997745694232, -46.73428043295)
        ),
        Evento(
            3,
            listOf(R.drawable.exposicao_chaves),
            "Exposição Vila do Chaves",
            "Mergulha no mundo do Chaves, com tudo que você já curtiu: cenários, figurinos, memes e muita resenha com a galera!",
            4.5F,
            LatLng(-23.51296927426321, -46.69478687364815)
        ),
        Evento(
            4,
            listOf(R.drawable.braziljs),
            "Brazil JS - Conf 2024",
            "O maior rolê de JavaScript do Brasil! Palestras marotas, workshops irados e network até o break do café!",
            4.3F,
            LatLng(-30.035453769869775, -51.2143120441744)
        ),
    )
}

fun obterEventoPorId(eventoId: Int): Evento? {
    return listarEventos().find { it.id == eventoId }
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
