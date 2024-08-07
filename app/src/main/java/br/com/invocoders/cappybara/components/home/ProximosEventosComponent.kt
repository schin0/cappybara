package br.com.invocoders.cappybara.components.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.invocoders.cappybara.components.CardEventoComponent
import br.com.invocoders.cappybara.services.listarEventosDetalhes

@Composable
fun ProximosEventosComponent() {
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
            CardEventoComponent(it)
        }
    }
}

