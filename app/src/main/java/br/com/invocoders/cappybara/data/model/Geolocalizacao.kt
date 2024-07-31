package br.com.invocoders.cappybara.data.model

data class Geolocalizacao(
    val results: List<Resultado>,
    val status: String
)

data class Resultado(
    val formatted_address: String
)