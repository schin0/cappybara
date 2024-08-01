package br.com.invocoders.cappybara.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.invocoders.cappybara.data.model.LoginRequest
import br.com.invocoders.cappybara.data.repository.LoginRepository
import br.com.invocoders.cappybara.services.LoginService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel(private val loginService: LoginService): ViewModel () {

    private val _loginState = MutableStateFlow<Result<String>>(Result.success(""))
    val loginState: StateFlow<Result<String>> = _loginState

}