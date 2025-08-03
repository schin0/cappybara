package br.com.invocoders.cappybara.view.components.quebragelo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R

@Composable
fun BotaoEscreverPropriaComponent(onClick: () -> Unit) {
    val roboto = FontFamily.Default
    
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "ESCREVA SUA PRÓPRIA",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.azul),
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
} 