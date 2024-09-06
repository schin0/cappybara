package br.com.invocoders.cappybara.data.repository

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RotaRepository {
    @GET("json")
    suspend fun getRoute(
        @Query("origin") origin: String,
        @Query("destination") destination: String,
        @Query("key") key: String,
        @Query("alternatives") alternatives:Boolean
    ): Response<ResponseBody>
}