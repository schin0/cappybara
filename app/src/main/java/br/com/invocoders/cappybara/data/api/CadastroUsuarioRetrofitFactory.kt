package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.CadastroUsuarioRepository
import br.com.invocoders.cappybara.data.repository.CategoriaEventoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CadastroUsuarioRetrofitFactory {
    private val URL = "https://cappybara-service-spring-app-cappybara-usuario.azuremicroservices.io/usuario/"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun cadastroUsuarioRepository() : CadastroUsuarioRepository {
        return retrofitFactory.create(CadastroUsuarioRepository::class.java)
    }
}