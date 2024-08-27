package br.com.invocoders.cappybara.data.model

data class EventoDetalhe(
    var id: Long,
    val titulo: String,
    val descricao: String,
    val latitude: Double,
    val longitude: Double,
    val categoriaEvento: Long,
    val preco: Double,
    val artistas: String,
    val dataHoraInicio: String,
    val imagens: List<String>
)