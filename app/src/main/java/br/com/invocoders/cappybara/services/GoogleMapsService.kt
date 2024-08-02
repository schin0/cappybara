package br.com.invocoders.cappybara.services

import br.com.invocoders.cappybara.data.api.GoogleMapsRetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun obterEnderecoTexto(latitude: Double, longitude: Double): String {
    return withContext(Dispatchers.IO) {
        val apiKey = "AIzaSyBFtsFp1S8yj0ljaqZWOheIAniJT7F2wzA"
        val response = GoogleMapsRetrofitFactory().googleMapsRepository().obterEndereco("$latitude,$longitude", apiKey)

        if (response.isSuccessful) {
            val endereco = response.body()?.results?.firstOrNull()?.formatted_address
            val nomeRua = endereco?.let { obterNomeRua(it) }

            nomeRua ?: "Endereço não encontrado"
        } else {
            "Erro ao obter endereço"
        }
    }
}

fun obterNomeRua(endereco: String): String {
    val partes = endereco.split(",")
    return partes.getOrNull(0)?.trim() ?: "Nome da rua não encontrado"
}
