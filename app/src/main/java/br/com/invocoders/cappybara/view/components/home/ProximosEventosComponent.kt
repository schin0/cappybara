package br.com.invocoders.cappybara.view.components.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.invocoders.cappybara.core.services.listarEventosDetalhes
import br.com.invocoders.cappybara.view.components.shared.CardEventoComponent

@Composable
fun ProximosEventosComponent(navController: NavController) {
    val scrollStateEventos = rememberScrollState(0)
    val proximosEventos = listarEventosDetalhes()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollStateEventos),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        proximosEventos.forEach {
            CardEventoComponent(it, navController)
        }
    }
}

