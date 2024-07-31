package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.data.model.Geolocalizacao
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleMapsRepository {
    @GET("geocode/json")
    suspend fun obterEndereco(
        @Query("latlng") latlng: String,
        @Query("key") apiKey: String
    ): Response<Geolocalizacao>
}