package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CadastroUsuarioRepository {
    @POST("cadastrar")
    fun cadastrarUsuario(@Body usuario: Usuario): Call<Usuario>
}