package br.com.invocoders.cappybara.model

data class Evento(
    val id: Int,
    val imagemIds: List<Int>,
    val titulo: String,
    val descricao: String,
    val avaliacao: Float,

    // TODO: Localização
)