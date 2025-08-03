package br.com.invocoders.cappybara.model

data class PerfilUsuario(
    val nome: String,
    val fotoPerfil: String = "",
    val conexoes: Int,
    val eventos: Int,
    val interesses: List<String>,
    val descricao: String
) 