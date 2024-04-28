package br.com.invocoders.cappybara.services

import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.CardItem

fun listarEventos(): List<CardItem> {
    return listOf(
        CardItem(
            imagemId = R.drawable.exposicao_chaves,
            avaliacao = 4.9F,
            titulo = "Exposição Vila do Chaves",
            destinoClique = "pesquisa"
        ),
        CardItem(
            imagemId = R.drawable.user_conf_manage_engine,
            avaliacao = 4.8F,
            titulo = "UserConf - Manage Engine",
            destinoClique = "pesquisa"
        ),
        CardItem(
            imagemId = R.drawable.major,
            avaliacao = 4.5F,
            titulo = "Major Counter Strike",
            destinoClique = "pesquisa"
        )
    )
}

fun obterEvento(navController: NavController, destinoClique: String) {
    navController.navigate(destinoClique)
}