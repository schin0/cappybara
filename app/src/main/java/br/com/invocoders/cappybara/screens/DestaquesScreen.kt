package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R

@Composable
fun DestaquesScreen() {
    Row (
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column {
            Card(
                modifier = Modifier
                    .size(150.dp, 150.dp),
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
                    .size(150.dp, 150.dp),
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