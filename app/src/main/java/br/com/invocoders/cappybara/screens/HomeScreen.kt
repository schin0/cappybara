package br.com.invocoders.cappybara.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Row {
            Text(text = "ola")
        }
        Row {
            Text(text = "ola")
        }
        Row {
            Text(text = "ola")
        }
        Row {
            Text(text = "ola")
        }
        Row {
            Text(text = "ola")
        }
        Row {
            Text(text = "ola")
        }
        Row {
            Text(text = "ola")
        }
    }

    MenuScreen(navController)
}