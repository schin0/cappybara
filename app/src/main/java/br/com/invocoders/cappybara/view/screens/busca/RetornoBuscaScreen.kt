package br.com.invocoders.cappybara.view.screens.busca

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.core.services.filtrarEventos
import br.com.invocoders.cappybara.data.model.FiltroEvento
import br.com.invocoders.cappybara.view.components.home.CardEventoPertoComponent
import br.com.invocoders.cappybara.view.components.shared.BotaoVoltar

@Composable
fun RetornoBuscaScreen(
    filtroEvento: FiltroEvento, navController: NavController
) {
    val eventosFiltrados = filtrarEventos(
        filtroEvento.idCategoria,
        filtroEvento.precoInicial,
        filtroEvento.precoFinal,
        filtroEvento.data
    )

    val scrollState = rememberScrollState(0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
        ) {
            BotaoVoltar(navController)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp)
                .verticalScroll(scrollState)
        ) {
            if (eventosFiltrados.isNotEmpty()) {
                eventosFiltrados.forEach {
                    CardEventoPertoComponent(it, navController)
                }
            }
        }
    }



}