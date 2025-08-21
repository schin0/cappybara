package br.com.invocoders.cappybara.model

data class IdeiaQuebraGelo(
    val categoria: String,
    val pergunta: String,
    val corFundo: String = "#FF6B9D",
    val id: String = "",
    val titulo: String = "",
    val descricao: String = "",
    val tipo: Int = 0,
    val tags: List<String> = emptyList(),
    val nivelDificuldade: Int = 1,
    val tempoEstimado: Int = 3
) 