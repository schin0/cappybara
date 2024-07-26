package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoMenuComponent
import br.com.invocoders.cappybara.components.BotaoQRCodeComponent
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun MenuScreenNovo(navController: NavController, itemSelecionado: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column {
            val botaoqrcode = MenuItem(
                "qrcode",
                R.drawable.baseline_qr_code_2_24,
                R.drawable.baseline_qr_code_2_24,
                "",
                false
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    BotaoQRCodeComponent(
                        botaoqrcode,
                        navController
                    )
                }
            }

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
                    .height(80.dp)
                    .zIndex(0f),
                horizontalArrangement = Arrangement.SpaceBetween
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
                        "buscar",
                        R.drawable.baseline_location_on_24,
                        R.drawable.baseline_location_on_24_laranja,
                        "Mapa",
                        habilitado = true
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
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        BotaoMenuComponent(item, item.nome == itemSelecionado, navController)
                    }
                }
            }
        }
    }
}