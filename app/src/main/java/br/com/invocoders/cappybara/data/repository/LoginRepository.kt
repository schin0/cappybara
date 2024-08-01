package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.data.model.AuthResponse
import br.com.invocoders.cappybara.data.model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginRepository {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST
   fun loginRequest(@Body request: LoginRequest): Call<AuthResponse>
}