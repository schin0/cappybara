package br.com.invocoders.cappybara.view.screens.detalheevento

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.core.services.obterEventoDetalhePorId

@Composable
fun DetalhesEventoScreen(eventoId: Long) {
    val evento = obterEventoDetalhePorId(eventoId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 100.dp)
    ) {
        Text(text = evento.titulo, color = Color.Black, fontSize = 32.sp)
    }
}