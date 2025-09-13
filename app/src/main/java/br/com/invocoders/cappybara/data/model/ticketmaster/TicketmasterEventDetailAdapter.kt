package br.com.invocoders.cappybara.data.model.ticketmaster

import br.com.invocoders.cappybara.data.model.EventoDetalhe

object TicketmasterEventDetailAdapter {
    
    fun converterParaEventoDetalhe(evento: TicketmasterEventDetail): EventoDetalhe {
        val localizacao = obterLocalizacao(evento)
        val dataHoraInicio = obterDataHoraInicio(evento)
        val dataHoraTermino = obterDataHoraTermino(evento)
        val imagens = obterImagens(evento)
        val descricao = obterDescricao(evento)
        val artistas = obterArtistas(evento)
        val preco = obterPreco(evento)
        val categoriaEvento = obterCategoriaEvento(evento)
        
        return EventoDetalhe(
            id = evento.id.hashCode().toLong(),
            titulo = evento.nome,
            descricao = descricao,
            latitude = localizacao.first,
            longitude = localizacao.second,
            categoriaEvento = categoriaEvento,
            preco = preco,
            artistas = artistas,
            dataHoraInicio = dataHoraInicio,
            dataHoraTermino = dataHoraTermino,
            imagens = imagens,
            clima = null
        )
    }
    
    private fun obterLocalizacao(evento: TicketmasterEventDetail): Pair<Double, Double> {
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
    
    private fun obterDataHoraInicio(evento: TicketmasterEventDetail): String {
        val dataInicio = evento.datas.inicio
        return if (dataInicio.horaLocal != null) {
            "${dataInicio.dataLocal}T${dataInicio.horaLocal}"
        } else {
            "${dataInicio.dataLocal}T00:00:00"
        }
    }
    
    private fun obterDataHoraTermino(evento: TicketmasterEventDetail): String {
        val dataInicio = evento.datas.inicio
        return if (dataInicio.horaLocal != null) {
            "${dataInicio.dataLocal}T${dataInicio.horaLocal}"
        } else {
            "${dataInicio.dataLocal}T00:00:00"
        }
    }
    
    private fun obterImagens(evento: TicketmasterEventDetail): List<String> {
        return evento.imagens
            .filter { it.proporcao == "16_9" }
            .take(5)
            .map { it.url }
    }
    
    private fun obterDescricao(evento: TicketmasterEventDetail): String {
        val classificacao = evento.classificacoes.firstOrNull()
        return if (classificacao != null) {
            "${classificacao.segmento.nome} - ${classificacao.genero.nome}"
        } else {
            "Evento"
        }
    }
    
    private fun obterArtistas(evento: TicketmasterEventDetail): String {
        return evento.embedded.atracoes.joinToString(", ") { it.nome }
    }
    
    private fun obterPreco(evento: TicketmasterEventDetail): Double {
        return 0.0
    }
    
    private fun obterCategoriaEvento(evento: TicketmasterEventDetail): Long {
        val classificacao = evento.classificacoes.firstOrNull()
        return classificacao?.genero?.id?.hashCode()?.toLong() ?: 0L
    }
}
