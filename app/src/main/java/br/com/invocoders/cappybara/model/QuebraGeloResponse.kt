package br.com.invocoders.cappybara.model

data class QuebraGeloResponse(
    val ideias: List<IdeiaQuebraGeloAPI>,
    val mensagemMotivacional: String,
    val contextoUtilizado: String
)

data class IdeiaQuebraGeloAPI(
    val id: String,
    val titulo: String,
    val descricao: String,
    val tipo: Int,
    val tags: List<String>,
    val nivelDificuldade: Int,
    val tempoEstimado: Int
)
