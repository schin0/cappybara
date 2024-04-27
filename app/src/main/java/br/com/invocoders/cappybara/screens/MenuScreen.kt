package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoComponente
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun MenuScreen(navController: NavController, itemSelecionado: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val botoes = listOf(
                MenuItem(
                    "home",
                    R.drawable.baseline_home_24,
                    R.drawable.baseline_home_24_white,
                    "Início"
                ),
                MenuItem(
                    "pesquisa",
                    R.drawable.baseline_search_24,
                    R.drawable.baseline_search_24_white,
                    "Pesquisar"
                ),
                MenuItem(
                    "home",
                    R.drawable.baseline_calendar_month_24,
                    R.drawable.baseline_calendar_month_24,
                    "Calendário",
                    habilitado = false
                )
            )

            botoes.forEach { item ->
                BotaoComponente(item, item.nome == itemSelecionado, navController)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMenuScreen() {
    val nav = rememberNavController()
    MenuScreen(nav, "home")
}