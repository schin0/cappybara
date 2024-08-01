package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.GoogleMapsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GoogleMapsRetrofitFactory {
    private val BASE_URL = "https://maps.googleapis.com/maps/api/"

    val retrofitFactory: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun googleMapsRepository() : GoogleMapsRepository {
        return retrofitFactory.create(GoogleMapsRepository::class.java)
    }
}