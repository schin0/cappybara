package br.com.invocoders.cappybara.view.components.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.invocoders.cappybara.R

@Composable
fun CardSecaoEvento(logo: ImageVector, logoDescricao: String, descricao: String) {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))

    Card(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.azul),
            contentColor = Color.Gray
        )
    ) {
        Column(
            modifier = Modifier
                .padding(11.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    logo,
                    contentDescription = logoDescricao,
                    tint = colorResource(
                        id = R.color.branco
                    ),
                )

                Icon(
                    painterResource(id = R.drawable.baseline_bookmark_24),
                    contentDescription = "Salvar",
                    tint = colorResource(
                        id = R.color.branco
                    ),
                )
            }

            Text(
                text = descricao,
                style = TextStyle(
                    fontSize = 19.73.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.88.sp,
                    fontFamily = roboto
                ),
                modifier = Modifier.padding(vertical = 15.dp)
            )
        }
    }
}