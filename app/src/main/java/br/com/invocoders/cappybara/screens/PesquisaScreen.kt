package br.com.invocoders.cappybara.screens

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.components.BotaoComponente
import br.com.invocoders.cappybara.model.MenuItem

@Composable
fun PesquisaScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, top = 16.dp, end = 32.dp, bottom = 64.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                enabled = false,
                placeholder = {
                    Text(text = "Pesquise pelo nome do evento")
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(230.dp, 40.dp)
                    .padding(0.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.Black,
                    disabledLabelColor = Color.Black,
                )
            )

            BotaoComponente(
                item = MenuItem(
                    "pesquisa",
                    R.drawable.baseline_search_24,
                    R.drawable.baseline_search_24_white,
                    "pesquisa"
                ),
                selecionado = true,
                navController = navController
            )
        }

        CategoriasScreen()

        DataScreen()

        IntervaloPreco()
        
        Spacer(modifier = Modifier.height(16.dp))

        EventosBombasticosScreen(navController)
    }

    MenuScreen(navController, "pesquisa")
}