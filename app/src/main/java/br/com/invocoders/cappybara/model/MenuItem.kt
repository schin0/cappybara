package br.com.invocoders.cappybara.model

data class MenuItem(
    val nome: String,
    val iconeId: Int,
    val iconeIdSelecionado: Int,
    val descricaoIcone: String,
    val habilitado: Boolean = true,
    val acaoDisponivel: Boolean = true
)
