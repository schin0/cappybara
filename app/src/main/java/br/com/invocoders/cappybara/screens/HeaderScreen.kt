package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.services.mostrarMensagemEmConstrucao

@Composable
fun HeaderScreen() {
    val contexto = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val image = painterResource(R.drawable.capivara)

        Image(
            painter = image,
            contentDescription = "Capivara",
            modifier = Modifier.size(35.dp, 35.dp)
        )

        Image(
            painterResource(id = R.drawable.outline_location_on_24),
            contentDescription = "Ícone localização",
            modifier = Modifier.size(35.dp, 35.dp)
        )

        Text(
            text = "Jundiaí",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                mostrarMensagemEmConstrucao(contexto)
            }
        )

        Image(
            painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
            contentDescription = "Ícone de seta",
            modifier = Modifier
                .size(35.dp, 35.dp)
                .clickable {
                    mostrarMensagemEmConstrucao(contexto)
                }
        )

        Image(
            painterResource(id = R.drawable.baseline_settings_24),
            contentDescription = "Ícone de configurações",
            modifier = Modifier
                .size(35.dp, 35.dp)
                .clickable {
                    mostrarMensagemEmConstrucao(contexto)
                }
        )
    }
}