package br.com.invocoders.cappybara.model

data class CardItem(
    val eventoId: Int,
    val imagemId: Int,
    val titulo: String,
    val avaliacao: Float,
    val destinoClique: String
)