package br.com.invocoders.cappybara.data.model

data class FiltroEvento(
    val idCategoria: List<Long>,
    val precoInicial: Float,
    val precoFinal: Float,
    val data: String,
)