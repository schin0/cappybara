package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.CardComponent
import br.com.invocoders.cappybara.model.CardItem

@Composable
fun EventosScreen(navController: NavController, tituloSecao: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = tituloSecao,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        
        Row {
            val listaEventos = listOf(
                CardItem(
                    imagem = painterResource(R.drawable.placeholder),
                    avaliacao = 5.0F,
                    titulo = "Teste",
                    destinoClique = "pesquisa"
                ),
                CardItem(
                    imagem = painterResource(R.drawable.placeholder),
                    avaliacao = 5.0F,
                    titulo = "Teste",
                    destinoClique = "pesquisa"
                )
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                listaEventos.forEach { card ->
                    CardComponent(card, navController)
                }
            }

        }
    }
}