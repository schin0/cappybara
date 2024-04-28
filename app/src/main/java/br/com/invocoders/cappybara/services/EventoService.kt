package br.com.invocoders.cappybara.services

import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.CardItem
import br.com.invocoders.cappybara.model.Evento

fun listarCardsEventos(): List<CardItem> {
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

fun listarEventos(): List<Evento> {
    return listOf(
        Evento(
            1,
            listOf(R.drawable.exposicao_chaves),
            "Exposição Vila do Chaves",
            "Descrição teste",
            4.9F
        ),
        Evento(
            2,
            listOf(R.drawable.user_conf_manage_engine),
            "UserConf - Manage Engine",
            "Descrição teste",
            4.9F
        ),
        Evento(
            3,
            listOf(R.drawable.major),
            "Major Counter Strike",
            "Descrição teste",
            4.5F
        ),
    )
}

fun obterEventoPorId(eventoId: Int): Evento? {
    return listarEventos().find { it.id == eventoId }
}