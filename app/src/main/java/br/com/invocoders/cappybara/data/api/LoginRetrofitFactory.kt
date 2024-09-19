package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.LoginRepository
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRetrofitFactory {
    private val URL = "https://cappybara-service2-spring-app-cappybara-usuario.azuremicroservices.io/"

    val gson = GsonBuilder()
        .setLenient()
        .create()

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun loginRepository(): LoginRepository {
        return retrofitFactory.create(LoginRepository::class.java)
    }
}