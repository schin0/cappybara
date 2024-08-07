package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.services.mostrarMensagemEmConstrucao

@Composable
fun DestaquesScreen() {
    val contexto = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                mostrarMensagemEmConstrucao(contexto)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.cinza_claro),
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Atrações do seu interesse",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(32.dp))
        Column {
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.cinza_claro),
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Eventos mais próximos de você",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}