package br.com.invocoders.cappybara.view.screens.telabuscar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.invocoders.cappybara.R

@Composable
fun CampoBuscaScreen(){
    Row {
        Image(
            painterResource(id = R.drawable.baseline_search_24),
            contentDescription = "Ícone de seta",
            modifier = Modifier
                .size(25.dp, 25.dp)
                .clickable {

                }
        )
        TextField(
            value = "",
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp), // Ajuste a altura conforme necessário
            placeholder = { "Buscar..." },
            singleLine = true,
            maxLines = 1
        )
    }
}