package br.com.invocoders.cappybara.services

import androidx.navigation.NavController
import br.com.invocoders.cappybara.R
import br.com.invocoders.cappybara.model.CardItem
import br.com.invocoders.cappybara.model.Evento

fun listarCardsEventos(): List<CardItem> {
    return listOf(
        CardItem(
            eventoId = 1,
            imagemId = R.drawable.user_conf_manage_engine,
            avaliacao = 4.9F,
            titulo = "UserConf - Manage Engine",
            destinoClique = "detalhesEvento/1"
        ),
        CardItem(
            eventoId = 2,
            imagemId = R.drawable.next2023,
            avaliacao = 4.8F,
            titulo = "Next - FIAP - 2024",
            destinoClique = "detalhesEvento/2"
        ),
        CardItem(
            eventoId = 3,
            imagemId = R.drawable.exposicao_chaves,
            avaliacao = 4.5F,
            titulo = "Exposição Vila do Chaves",
            destinoClique = "detalhesEvento/3"
        ),
        CardItem(
            eventoId = 4,
            imagemId = R.drawable.braziljs,
            avaliacao = 4.3F,
            titulo = "Brazil JS - Conf 2024",
            destinoClique = "detalhesEvento/4"
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
            listOf(R.drawable.user_conf_manage_engine),
            "UserConf - Manage Engine",
            "Descrição teste",
            4.9F
        ),
        Evento(
            2,
            listOf(R.drawable.next2023),
            "Next - FIAP - 2024",
            "Descrição teste",
            4.8F
        ),
        Evento(
            3,
            listOf(R.drawable.exposicao_chaves),
            "Exposição Vila do Chaves",
            "Descrição teste",
            4.5F
        ),
        Evento(
            4,
            listOf(R.drawable.braziljs),
            "Brazil JS - Conf 2024",
            "Descrição teste",
            4.3F
        ),
    )
}

fun obterEventoPorId(eventoId: Int): Evento? {
    return listarEventos().find { it.id == eventoId }
}