package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoComponente
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun EventosBombasticosScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_star_24_white),
                    contentDescription = "Logo de estrela",
                    Modifier
                        .padding(15.dp)
                )

                Text(
                    text = "Tá bombando!",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.cinza_claro),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BotaoComponente(
                            item = MenuItem(
                                "pesquisa",
                                R.drawable.baseline_emoji_events_24,
                                R.drawable.baseline_emoji_events_24,
                                "eventos",
                                habilitado = false
                            ),
                            selecionado = true,
                            navController = navController
                        )
                        
                        Text(text = "Top 10 Eventos", color = Color.Black)

                        Image(
                            painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                            contentDescription = "Logo de estrela",
                            Modifier
                                .padding(15.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 0.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.cinza_claro),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BotaoComponente(
                            item = MenuItem(
                                "pesquisa",
                                R.drawable.baseline_emoji_events_24,
                                R.drawable.baseline_emoji_events_24,
                                "eventos",
                                habilitado = false
                            ),
                            selecionado = true,
                            navController = navController
                        )

                        Text(text = "Favoritos dos Cappys", color = Color.Black)

                        Image(
                            painter = painterResource(id = R.drawable.baseline_favorite_24),
                            contentDescription = "Logo de estrela",
                            Modifier
                                .padding(15.dp)
                        )
                    }
                }
            }
        }
    }
}