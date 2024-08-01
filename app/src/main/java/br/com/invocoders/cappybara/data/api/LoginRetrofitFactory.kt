package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.LoginRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRetrofitFactory {
    private val URL = "http://192.168.1.10:8081/auth"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
        .build()

    fun loginRepository() : LoginRepository {
        return retrofitFactory.create(LoginRepository::class.java)
    }
}