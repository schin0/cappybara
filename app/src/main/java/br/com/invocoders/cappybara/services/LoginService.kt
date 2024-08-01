package br.com.invocoders.cappybara.services

import androidx.compose.runtime.Composable
import br.com.invocoders.cappybara.data.model.AuthResponse
import br.com.invocoders.cappybara.data.model.LoginRequest
import br.com.invocoders.cappybara.data.repository.LoginRepository
import br.com.invocoders.cappybara.viewmodel.LoginViewModel
import retrofit2.Call


class LoginService(private val loginRepository: LoginRepository) {

    fun login(email: String, senha: String): Call<AuthResponse> {
        return loginRepository.loginRequest(LoginRequest(email, senha))
    }
}