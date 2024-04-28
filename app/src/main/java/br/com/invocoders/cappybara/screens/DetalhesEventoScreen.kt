package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.model.CardItem
import br.com.invocoders.cappybara.services.obterEventoPorId

@Composable
fun DetalhesEventoScreen(navController: NavController, eventoId: Int) {
    // TODO: Criar classe evento e listar evento
    val evento = obterEventoPorId(eventoId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        if (evento is CardItem) {
            Text(
                text = evento.titulo,
                color = Color.Black
            )

            return
        }

        Text(
            text = "Não foi possível encontrar o evento. Busque novamente.",
            color = Color.Black
        )

    }

    MenuScreen(navController = navController, itemSelecionado = "home")
}