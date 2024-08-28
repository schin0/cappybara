package br.com.invocoders.cappybara.data.model

data class EventoResumo(
    val id: Long,
    val titulo: String,
    val latitude: Double,
    val longitude: Double,
    val dataHoraInicio: String,
    val urlImagem: List<String>
)