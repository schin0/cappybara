package br.com.invocoders.cappybara.core.utils

import java.util.Calendar

object ContextoQuebraGeloService {
    
    fun obterHoraAtual(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.HOUR_OF_DAY)
    }
    
    fun obterDiaSemana(): String {
        val calendar = Calendar.getInstance()
        val diasSemana = listOf(
            "domingo", "segunda-feira", "terça-feira", "quarta-feira", 
            "quinta-feira", "sexta-feira", "sábado"
        )
        return diasSemana[calendar.get(Calendar.DAY_OF_WEEK) - 1]
    }
    
    fun obterEstacaoAno(): String {
        val calendar = Calendar.getInstance()
        val mes = calendar.get(Calendar.MONTH) + 1
        
        return when (mes) {
            in 12..2 -> "Verão"
            in 3..5 -> "Outono"
            in 6..8 -> "Inverno"
            in 9..11 -> "Primavera"
            else -> "Verão"
        }
    }
    
    fun obterClimaAtual(): String {
        val hora = obterHoraAtual()
        val estacao = obterEstacaoAno()
        
        return when {
            hora in 6..18 && estacao == "Verão" -> "Quente"
            hora in 6..18 && estacao == "Inverno" -> "Frio"
            hora in 6..18 -> "Temperado"
            else -> "Fresco"
        }
    }
    
    fun obterLocalizacaoPadrao(): String {
        return "São Paulo"
    }
    
    fun obterInteressesUsuario(): List<String> {
        return listOf("música", "festa", "tecnologia", "esportes", "viagem")
    }
}
