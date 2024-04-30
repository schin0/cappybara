package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IntervaloPreco() {
    var valorLimiteDesejado by remember { mutableFloatStateOf(0f) }
    val valorMaximo = 100f

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Faixa de preço",
                color = Color.Black
            )

            Text(
                text = "R$ ${valorLimiteDesejado.toString().substringBefore(".")}",
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = valorLimiteDesejado,
            onValueChange = { valorLimiteDesejado = it.coerceIn(0f, valorMaximo) },
            valueRange = 0f..valorMaximo,
            colors = SliderDefaults.colors(
                thumbColor = Color.Black,
                activeTrackColor = Color.DarkGray,
                inactiveTrackColor = Color.LightGray,
            ),
        )
    }

}