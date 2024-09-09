package br.com.invocoders.cappybara.model

import br.com.invocoders.cappybara.data.enuns.RoleEnum
import java.util.Date

data class Usuario(val nome: String, val email: String, val senha: String, val dataNascimento: String, val role: String)
