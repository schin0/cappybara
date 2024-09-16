package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.ClimaRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClimaRetrofitFactory {
    private val URL = "https://api.openweathermap.org/data/2.5/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun climaRetrofitFactory(): ClimaRepository {
        return retrofitFactory.create(ClimaRepository::class.java)
    }
}