package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.services.mostrarMensagemEmConstrucao

@Composable
fun CategoriasScreen() {
    val contexto = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
            .clickable {
                mostrarMensagemEmConstrucao(contexto)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_party_mode_24),
                contentDescription = "Logo de festa",
                Modifier
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(15.dp)
            )
            Text(text = "Exposições", color = Color.Black)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_local_drink_24),
                contentDescription = "Logo de festa",
                Modifier
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(15.dp)
            )
            Text(text = "Drinks", color = Color.Black)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_fastfood_24),
                contentDescription = "Logo de festa",
                Modifier
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(15.dp)
            )
            Text(text = "Comidas", color = Color.Black)
        }

    }
}