package br.com.invocoders.cappybara.view.screens.busca

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.invocoders.cappybara.core.services.filtrarEventos
import br.com.invocoders.cappybara.data.model.FiltroEvento
import br.com.invocoders.cappybara.view.components.home.CardEventoPertoComponent

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

    if (eventosFiltrados.isNotEmpty()) {
        eventosFiltrados.forEach {
            CardEventoPertoComponent(it, navController)
        }
    }

}