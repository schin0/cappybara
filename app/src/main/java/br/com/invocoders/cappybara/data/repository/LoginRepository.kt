package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.data.model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRepository {
    @POST("auth")
    fun loginRequest(@Body request: LoginRequest): Call<String>
}