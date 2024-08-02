package br.com.invocoders.cappybara.data.model

data class EventoDetalhe(
    val id: Long,
    val titulo: String,
    val latitude: Double,
    val longitude: Double,
    val dataHoraInicio: String,
    val urlImagem: List<String>
)
// TODO: Evento Resumo