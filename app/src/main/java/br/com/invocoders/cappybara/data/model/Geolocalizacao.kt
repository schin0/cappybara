package br.com.invocoders.cappybara.data.model

data class Geolocalizacao(
    val retorno: List<Resultado>,
    val status: String
)

data class Resultado(
    val endereco: String
)