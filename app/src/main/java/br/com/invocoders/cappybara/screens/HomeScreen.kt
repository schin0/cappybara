package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 64.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        HeaderScreen()

        Spacer(modifier = Modifier.height(20.dp))

        DestaquesScreen()

        EventosScreen(navController, "Melhores avaliações")
    }

    //MenuScreen(navController, "home")
    MenuScreenNovo(navController, "home")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    val nav = rememberNavController()
    HomeScreen(nav)
}