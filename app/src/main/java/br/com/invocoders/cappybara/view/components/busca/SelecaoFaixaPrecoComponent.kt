package br.com.invocoders.cappybara.view.components.busca

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SelecaoFaixaPrecoComponent(onPrecoSelecionado: (Float) -> Unit) {
    Spacer(modifier = Modifier.height(10.dp))

    val valorMinimo by remember { mutableFloatStateOf(20f) }
    val valorMaximo by remember { mutableFloatStateOf(120f) }
    var valorSelecionado by remember { mutableFloatStateOf(valorMinimo) }

    Column {
        Text(
            text = "R$${valorMinimo.toInt()}-R$${valorSelecionado.toInt()}",
            color = Color(0xFF6F7CF5),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = valorSelecionado,
            onValueChange = { valor ->
                valorSelecionado = valor
            },
            onValueChangeFinished = {
                onPrecoSelecionado(valorSelecionado)
            },
            valueRange = valorMinimo..valorMaximo,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF6F7CF5),
                activeTrackColor = Color(0xFF6F7CF5),
                inactiveTrackColor = Color(0xFFD0D0D0)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)
        )
    }


}