package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.EventoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventoRetrofitFactory {
    private val URL = "http://cappybara-evento-dyagdvfdfbd3hvg3.brazilsouth-01.azurewebsites.net/evento/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun eventoRepository() : EventoRepository {
        return retrofitFactory.create(EventoRepository::class.java)
    }
}