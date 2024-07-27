package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
        modifier = Modifier.fillMaxWidth()
        //horizontalArrangement = Arrangement.End
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row  {
            Text(
                text = "localização",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    mostrarMensagemEmConstrucao(contexto)
                }
            )

            Image(
                painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                contentDescription = "Ícone de seta",
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .clickable {
                        mostrarMensagemEmConstrucao(contexto)
                    }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row {
            Image(
                painterResource(id = R.drawable.baseline_notifications_none_24),
                contentDescription = "Ícone de configurações",
                modifier = Modifier
                    .size(35.dp, 35.dp)
                    .padding(end = 4.dp, bottom = 5.dp)
                    .clickable {
                        mostrarMensagemEmConstrucao(contexto)
                    }
            )
        }



    }
}