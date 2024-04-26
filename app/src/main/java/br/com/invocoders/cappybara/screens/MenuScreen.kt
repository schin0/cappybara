package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import br.com.invocoders.cappybara.R

@Composable
fun MenuScreen(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {
            navController.navigate("menu")
        }) {
            Image(painter = painterResource(id = R.drawable.baseline_home_24), contentDescription = "Ícone home")
        }

        Button(onClick = {
            navController.navigate("pesquisa")
        }) {
            Image(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "Ícone home")
        }

        Button(onClick = {
            navController.navigate("menu")
        }) {
            Image(painter = painterResource(id = R.drawable.baseline_home_24), contentDescription = "Ícone home")
        }
    }
}