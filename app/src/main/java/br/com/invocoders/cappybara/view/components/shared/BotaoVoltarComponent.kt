package br.com.invocoders.cappybara.view.components.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BotaoVoltar(navController: NavController) {
    IconButton(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .background(Color.Transparent),
        colors = IconButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        onClick = { navController.popBackStack() }) {
        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Botão voltar")
    }
}