package br.com.invocoders.cappybara.core.utils

fun abreviarDuracao(duracao: String): String {
    return duracao
        .replace("hours", "h")
        .replace("hour", "h")
        .replace("mins", "m")
        .replace("min", "m")
        .replace("and", "")
        .trim()
}
