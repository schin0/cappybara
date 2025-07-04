package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.CadastroUsuarioRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CadastroUsuarioRetrofitFactory {
    private val URL = "http://cappybara-evento-dyagdvfdfbd3hvg3.brazilsouth-01.azurewebsites.net/usuario/"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun cadastroUsuarioRepository() : CadastroUsuarioRepository {
        return retrofitFactory.create(CadastroUsuarioRepository::class.java)
    }
}