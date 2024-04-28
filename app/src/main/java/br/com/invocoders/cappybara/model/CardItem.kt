package br.com.invocoders.cappybara.model

import androidx.compose.ui.graphics.painter.Painter

data class CardItem(
    val imagemId: Int,
    val titulo: String,
    val avaliacao: Float,
    val destinoClique: String
)