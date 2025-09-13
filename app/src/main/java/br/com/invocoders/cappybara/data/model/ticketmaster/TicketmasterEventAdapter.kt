package br.com.invocoders.cappybara.data.model.ticketmaster

import br.com.invocoders.cappybara.data.model.EventoResumo

object TicketmasterEventAdapter {
    
    fun converterParaEventoResumo(evento: TicketmasterEvent): EventoResumo {
        val localizacao = obterLocalizacao(evento)
        val dataHoraInicio = obterDataHoraInicio(evento)
        val imagens = obterImagens(evento)
        
        return EventoResumo(
            id = evento.id.hashCode().toLong(),
            titulo = evento.nome,
            latitude = localizacao.first,
            longitude = localizacao.second,
            dataHoraInicio = dataHoraInicio,
            urlImagem = imagens,
            ticketmasterId = evento.id
        )
    }
    
    private fun obterLocalizacao(evento: TicketmasterEvent): Pair<Double, Double> {
        val local = evento.embedded.locais.firstOrNull()
        return if (local != null) {
            Pair(
                local.localizacao.latitude.toDouble(),
                local.localizacao.longitude.toDouble()
            )
        } else {
            Pair(0.0, 0.0)
        }
    }
    
    private fun obterDataHoraInicio(evento: TicketmasterEvent): String {
        val dataInicio = evento.datas.inicio
        return if (dataInicio.horaLocal != null) {
            "${dataInicio.dataLocal}T${dataInicio.horaLocal}"
        } else {
            "${dataInicio.dataLocal}T00:00:00"
        }
    }
    
    private fun obterImagens(evento: TicketmasterEvent): List<String> {
        return evento.imagens
            .filter { it.proporcao == "16_9" }
            .take(3)
            .map { it.url }
    }
}
