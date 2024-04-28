package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoComponente
import br.com.invocoders.cappybara.model.Evento
import br.com.invocoders.cappybara.model.MenuItem
import br.com.invocoders.cappybara.services.obterEventoPorId

@Composable
fun DetalhesEventoScreen(navController: NavController, eventoId: Int) {
    val evento = obterEventoPorId(eventoId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BotaoComponente(
                MenuItem(
                    "home",
                    R.drawable.baseline_arrow_back_24,
                    R.drawable.baseline_arrow_back_24,
                    "voltar"
                ), false, navController
            )

            Image(
                painterResource(id = R.drawable.baseline_settings_24),
                contentDescription = "Ícone de configurações",
                modifier = Modifier.size(35.dp, 35.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (evento is Evento) {
            Image(
                painter = painterResource(id = evento.imagemIds[0]),
                contentDescription = evento.titulo
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = evento.titulo,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = evento.descricao,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            MapScreen()

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "COMO CHEGAR")
                }
            }
        } else {
            Text(
                text = "Não foi possível encontrar o evento. Busque novamente.",
                color = Color.Black
            )
        }
    }

    MenuScreen(navController = navController, itemSelecionado = "home")
}