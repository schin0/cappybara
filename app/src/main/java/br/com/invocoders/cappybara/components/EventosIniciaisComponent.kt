package br.com.invocoders.cappybara.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EventosIniciaisComponent(textoEvento: String, imagemId: Int) {
    val roboto = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))

    Card(
        modifier = Modifier
            .width(164.dp)
            .height(113.dp)
            .padding(end = 10.dp),
        colors = CardColors(
            containerColor = Color.Red,
            contentColor = Color.Black,
            disabledContentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF)
        )
    ) {
        Box {
            Image(
                painterResource(id = imagemId),
                contentDescription = "Eventos",
                Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = textoEvento,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.15.sp,
                    )
                )
            }
        }
    }
}