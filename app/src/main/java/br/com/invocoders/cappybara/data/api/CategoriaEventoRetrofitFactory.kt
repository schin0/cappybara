package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.CategoriaEventoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriaEventoRetrofitFactory {
    private val URL = "http://cappybara-evento-dyagdvfdfbd3hvg3.brazilsouth-01.azurewebsites.net/categoria/"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun categoriaEventoRepository() : CategoriaEventoRepository {
        return retrofitFactory.create(CategoriaEventoRepository::class.java)
    }
}