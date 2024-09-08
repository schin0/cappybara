package br.com.invocoders.cappybara.core.services

import android.util.Log
import br.com.invocoders.cappybara.data.api.CadastroUsuarioRetrofitFactory
import br.com.invocoders.cappybara.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun cadastrarUsuario(usuario: Usuario){
    val call = CadastroUsuarioRetrofitFactory().cadastroUsuarioRepository().cadastrarUsuario(usuario)

    call.enqueue(object : Callback<Usuario> {
        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
            if (response.isSuccessful) {
                val usuarioResposta = response.body()
                Log.d("Sucesso", "Usuário criado: $usuarioResposta")
            } else {
                Log.e("Erro", "Erro ao criar usuário: ${response.errorBody()}")
            }
        }

        override fun onFailure(call: Call<Usuario>, t: Throwable) {
            Log.e("Erro", "Falha na requisição: ${t.message}")
        }
    })
}