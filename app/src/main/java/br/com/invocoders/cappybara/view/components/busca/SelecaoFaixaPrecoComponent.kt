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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SelecaoFaixaPrecoComponent() {
    Spacer(modifier = Modifier.height(10.dp))

    Column {
        Text(
            text = "R$20-R$120",
            color = Color(0xFF6F7CF5),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = 0.5f,
            onValueChange = { /* TODO: Atualizar faixa de preço */ },
            valueRange = 0f..1f,
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