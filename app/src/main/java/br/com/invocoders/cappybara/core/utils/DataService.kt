package br.com.invocoders.cappybara.core.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatarDataHora(dataHoraInicio: String, dataHoraTermino: String): Pair<String, String> {
    if (dataHoraTermino.isEmpty() || dataHoraTermino.isEmpty())
        return Pair("", "")

    val formatoEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

    val inicio = LocalDateTime.parse(dataHoraInicio, formatoEntrada)
    val termino = LocalDateTime.parse(dataHoraTermino, formatoEntrada)

    val formatoData = DateTimeFormatter.ofPattern("d 'de' MMMM, yyyy", Locale("pt", "BR"))
    val formatoHorario = DateTimeFormatter.ofPattern("EEEE, h:mm a", Locale("pt", "BR"))

    val dataFormatada = inicio.format(formatoData)
    val horarioFormatado = "${inicio.format(formatoHorario)} - ${termino.format(DateTimeFormatter.ofPattern("h:mm a"))}"

    return Pair(dataFormatada, horarioFormatado)
}
