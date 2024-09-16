package br.com.invocoders.cappybara.data.repository

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface ClimaRepository {
    @GET("weather")
    fun obterClima(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ): Call<Any>
}
