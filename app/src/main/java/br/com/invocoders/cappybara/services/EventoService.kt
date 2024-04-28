package br.com.invocoders.cappybara.services

import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.CardItem

// TODO: Alterar para listarCardsEventos?
fun listarEventos(): List<CardItem> {
    return listOf(
        CardItem(
            eventoId = 1,
            imagemId = R.drawable.exposicao_chaves,
            avaliacao = 4.9F,
            titulo = "Exposição Vila do Chaves",
            destinoClique = "detalhesEvento/1"
        ),
        CardItem(
            eventoId = 2,
            imagemId = R.drawable.user_conf_manage_engine,
            avaliacao = 4.8F,
            titulo = "UserConf - Manage Engine",
            destinoClique = "detalhesEvento/2"
        ),
        CardItem(
            eventoId = 3,
            imagemId = R.drawable.major,
            avaliacao = 4.5F,
            titulo = "Major Counter Strike",
            destinoClique = "detalhesEvento/3"
        )
    )
}

fun abrirEvento(navController: NavController, destinoClique: String) {
    navController.navigate(destinoClique)
}

fun obterEventoPorId(eventoId: Int): CardItem? {
    return listarEventos().find { it.eventoId == eventoId }
}