package br.com.invocoders.cappybara.services

import br.com.invocoders.cappybara.data.api.LoginRetrofitFactory
import br.com.invocoders.cappybara.data.model.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService {
    fun logar(
        email: String,
        senha: String,
        onLoginSuccess: () -> Unit,
        onLoginFailure: () -> Unit
    ) {
        val call = LoginRetrofitFactory()
            .loginRepository()
            .loginRequest(
                LoginRequest(email = email, senha = senha)
            )

        call.enqueue(object : Callback<String> {
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.isSuccessful && response.body().toString() != "") {
                    onLoginSuccess()
                } else {
                    onLoginFailure()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                onLoginFailure()
            }
        })
    }
}