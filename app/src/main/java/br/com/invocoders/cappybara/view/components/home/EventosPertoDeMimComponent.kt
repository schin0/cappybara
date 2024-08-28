package br.com.invocoders.cappybara.view.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.invocoders.cappybara.core.services.listarEventosProximos

@Composable
fun EventosPertoDeMimComponent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val eventosPerto = listarEventosProximos()

        if (eventosPerto.isNotEmpty()) {
            eventosPerto.forEach {
                CardEventoPertoComponent(it, navController)
            }
        }
    }
}