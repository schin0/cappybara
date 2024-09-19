package br.com.invocoders.cappybara.core.utils

import java.time.DayOfWeek
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
    val horarioFormatado =
        "${inicio.format(formatoHorario)} - ${termino.format(DateTimeFormatter.ofPattern("h:mm a"))}"

    return Pair(dataFormatada, horarioFormatado)
}

fun formatarDataComDiaSemana(dataInicio: String): String {
    val dataHora = LocalDateTime.parse(dataInicio)

    val formatterData = DateTimeFormatter.ofPattern("dd MMM", Locale("pt", "BR"))
    val diaFormatado = dataHora.format(formatterData).uppercase()

    val diaSemana = when (dataHora.dayOfWeek) {
        DayOfWeek.MONDAY -> "SEG"
        DayOfWeek.TUESDAY -> "TER"
        DayOfWeek.WEDNESDAY -> "QUA"
        DayOfWeek.THURSDAY -> "QUI"
        DayOfWeek.FRIDAY -> "SEX"
        DayOfWeek.SATURDAY -> "SÁB"
        DayOfWeek.SUNDAY -> "DOM"
    }

    val formatterHora = DateTimeFormatter.ofPattern("HH'h'mm")
    val horaFormatada = dataHora.format(formatterHora)

    return "$diaFormatado - $diaSemana - $horaFormatada"

}