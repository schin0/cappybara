package br.com.invocoders.cappybara.view.screens.busca

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.view.components.shared.CardSecaoEvento

@Composable
fun TaBombandoScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Ta bombando!",
            style = TextStyle(
                fontSize = 19.73.sp,
                lineHeight = 17.54.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF464655),
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CardSecaoEvento(Icons.Filled.ShoppingCart, "Comprar", "Top 10 Eventos")

            CardSecaoEvento(Icons.Filled.ShoppingCart, "Comprar", "Para mim")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CardSecaoEvento(Icons.Filled.ShoppingCart, "Comprar", "Meus Amigos")

            CardSecaoEvento(Icons.Filled.ShoppingCart, "Comprar", "Favoritos dos Cappys")
        }

    }
}
