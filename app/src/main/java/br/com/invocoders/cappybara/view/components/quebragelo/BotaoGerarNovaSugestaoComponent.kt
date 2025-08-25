package br.com.invocoders.cappybara.view.components.quebragelo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R

@Composable
fun BotaoGerarNovaSugestaoComponent(
    onClick: () -> Unit,
    habilitado: Boolean = true
) {
    val roboto = FontFamily.Default
    
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        enabled = habilitado,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (habilitado) colorResource(id = R.color.azul) else colorResource(id = R.color.azul).copy(alpha = 0.6f)
        )
    ) {
        Text(
            text = "GERAR NOVA SUGESTÃO",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.branco)
            )
        )
    }
} 