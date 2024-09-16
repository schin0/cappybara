package br.com.invocoders.cappybara.data.model

import br.com.invocoders.cappybara.model.Clima

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
    val dataHoraTermino: String,
    val imagens: List<String>,
    val clima: Clima?
)