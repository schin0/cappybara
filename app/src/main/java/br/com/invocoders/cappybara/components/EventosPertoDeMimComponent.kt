package br.com.invocoders.cappybara.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.invocoders.cappybara.components.home.CardEventoPertoComponent
import br.com.invocoders.cappybara.services.listarEventosProximos

@Composable
fun EventosPertoDeMimComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val eventosPerto = listarEventosProximos()

        if (eventosPerto.isNotEmpty()) {
            eventosPerto.forEach {
                CardEventoPertoComponent(it)
            }
        }
    }
}