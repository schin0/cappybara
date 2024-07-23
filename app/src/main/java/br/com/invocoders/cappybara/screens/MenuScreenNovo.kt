package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoComponente
import br.com.invocoders.cappybara.components.BotaoMenuComponent
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun MenuScreenNovo(navController: NavController, itemSelecionado: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Row(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color(0x219DB2D6),
                    ambientColor = Color(0x219DB2D6)
                )
                .background(
                    color = colorResource(id = R.color.branco)
                )
                .fillMaxWidth()
                .height(88.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val botoes = listOf(
                MenuItem(
                    "home",
                    R.drawable.baseline_explore_24,
                    R.drawable.baseline_explore_24_laranja,
                    "Explorar"
                ),
                MenuItem(
                    "pesquisa",
                    R.drawable.baseline_calendar_month_24,
                    R.drawable.baseline_calendar_month_24_laranja,
                    "Eventos"
                ),
                MenuItem(
                    "pesquisa",
                    R.drawable.baseline_location_on_24,
                    R.drawable.baseline_location_on_24_laranja,
                    "Mapa",
                    habilitado = false
                ),
                MenuItem(
                    "pesquisa",
                    R.drawable.baseline_person_24,
                    R.drawable.baseline_person_24_laranja,
                    "Perfil",
                    habilitado = false
                )
            )

            botoes.forEach { item ->
                BotaoMenuComponent(item, item.nome == itemSelecionado, navController)
            }
        }
    }
}