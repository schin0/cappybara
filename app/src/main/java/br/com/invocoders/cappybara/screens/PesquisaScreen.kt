package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.services.mostrarMensagemEmConstrucao

@Composable
fun PesquisaScreen(navController: NavController) {
    val contexto = LocalContext.current

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

            Button(
                onClick = {
                    mostrarMensagemEmConstrucao(contexto)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24_white),
                    contentDescription = "pesquisa"
                )
            }
        }

        CategoriasScreen()

        DataScreen()

        IntervaloPreco()
        
        Spacer(modifier = Modifier.height(16.dp))

        EventosBombasticosScreen(navController)
    }

    MenuScreen(navController, "pesquisa")
}