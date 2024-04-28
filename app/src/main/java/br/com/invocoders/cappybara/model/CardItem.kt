package br.com.invocoders.cappybara.model

import androidx.compose.ui.graphics.painter.Painter

data class CardItem(
    val imagem: Painter,
    val titulo: String,
    val avaliacao: Float
)