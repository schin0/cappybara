package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.LoginRepository
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRetrofitFactory {
    private val URL = "http://cappybara-evento-dyagdvfdfbd3hvg3.brazilsouth-01.azurewebsites.net/"

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