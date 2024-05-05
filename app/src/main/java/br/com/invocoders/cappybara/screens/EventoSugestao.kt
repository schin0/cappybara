package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoComponente
import br.com.invocoders.cappybara.model.EventoBombastico
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun EventoSugestao(
    navController: NavController,
    evento: EventoBombastico
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = evento.corId),
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
                        evento.nomeIcone,
                        evento.imagemIconeId,
                        evento.imagemIconeId,
                        evento.descricaoIcone,
                        habilitado = false
                    ),
                    selecionado = true,
                    navController = navController
                )

                Text(text = evento.nomeEvento, color = Color.Black)

                Image(
                    painter = painterResource(id = evento.imagemFavoritoId),
                    contentDescription = "Logo favorito",
                    Modifier
                        .padding(15.dp)
                )
            }
        }
    }
}