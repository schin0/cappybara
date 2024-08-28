package br.com.invocoders.cappybara.view.components.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun ImagemUsuarioComponent(
    width: Dp,
    height: Dp,
    zIndex: Float,
    containerColor: Color,
    contentColor: Color,
    offSetX: Dp
) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp)
            .width(width)
            .height(height)
            .offset(
                x = (offSetX)
            )
            .zIndex(zIndex),
        shape = RoundedCornerShape(size = 50.dp),
        colors = CardColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF)
        )
    ) { }
}