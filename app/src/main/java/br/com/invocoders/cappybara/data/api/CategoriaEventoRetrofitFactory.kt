package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.CategoriaEventoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriaEventoRetrofitFactory {
    private val URL = "https://cappybara-service2-spring-app-cappybara-evento.azuremicroservices.io/categoria/"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun categoriaEventoRepository() : CategoriaEventoRepository {
        return retrofitFactory.create(CategoriaEventoRepository::class.java)
    }
}