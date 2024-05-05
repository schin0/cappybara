package br.com.invocoders.cappybara.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.CardItem
import br.com.invocoders.cappybara.services.abrirEvento

@Composable
fun CardComponent(cardItem: CardItem, navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth()
            .clickable {
                abrirEvento(navController, cardItem.destinoClique)
            },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = cardItem.imagemId),
                contentDescription = cardItem.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = cardItem.titulo,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(
                        text = "${cardItem.avaliacao}",
                        color = Color.Black
                    )
                    Image(
                        painterResource(id = R.drawable.baseline_stars_24),
                        contentDescription = "Ícone estrela",
                        modifier = Modifier
                            .size(20.dp, 20.dp)
                            .padding(start = 4.dp)
                    )
                }
            }
        }
    }
}
