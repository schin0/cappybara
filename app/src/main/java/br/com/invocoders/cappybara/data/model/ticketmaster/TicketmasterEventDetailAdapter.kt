package br.com.invocoders.cappybara.data.model.ticketmaster

import br.com.invocoders.cappybara.data.model.ArtistaInfo
import br.com.invocoders.cappybara.data.model.ClassificacaoArtista
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.GeneroArtista
import br.com.invocoders.cappybara.data.model.LinkExterno
import br.com.invocoders.cappybara.data.model.LinkMusicBrainz
import br.com.invocoders.cappybara.data.model.LinksExternos
import br.com.invocoders.cappybara.data.model.ProximosEventosArtista
import br.com.invocoders.cappybara.data.model.SegmentoArtista
import br.com.invocoders.cappybara.data.model.SubGeneroArtista
import br.com.invocoders.cappybara.data.model.SubTipoArtista
import br.com.invocoders.cappybara.data.model.TipoArtista

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
        val artistaInfo = obterArtistaInfo(evento)
        
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
            clima = null,
            artistaInfo = artistaInfo
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
        val imagens16_9 = evento.imagens.filter { it.proporcao == "16_9" }
        
        if (imagens16_9.isEmpty()) {
            return evento.imagens
                .sortedByDescending { it.largura * it.altura }
                .take(5)
                .map { it.url }
        }
        
        return imagens16_9
            .sortedByDescending { it.largura * it.altura }
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
    
    private fun obterArtistaInfo(evento: TicketmasterEventDetail): ArtistaInfo? {
        val atracao = evento.embedded.atracoes.firstOrNull() ?: return null
        
        val linksExternos = atracao.linksExternos?.let { links ->
            LinksExternos(
                youtube = links.youtube?.map { LinkExterno(it.url) },
                twitter = links.twitter?.map { LinkExterno(it.url) },
                itunes = links.itunes?.map { LinkExterno(it.url) },
                spotify = links.spotify?.map { LinkExterno(it.url) },
                wiki = links.wiki?.map { LinkExterno(it.url) },
                facebook = links.facebook?.map { LinkExterno(it.url) },
                instagram = links.instagram?.map { LinkExterno(it.url) },
                musicbrainz = links.musicbrainz?.map { LinkMusicBrainz(it.id, it.url) }
            )
        }
        
        val imagensArtista = atracao.imagens
            .sortedByDescending { it.largura * it.altura }
            .take(3)
            .map { it.url }
        
        val classificacoes = atracao.classificacoes.map { classificacao ->
            ClassificacaoArtista(
                primario = classificacao.primario,
                segmento = SegmentoArtista(classificacao.segmento.id, classificacao.segmento.nome),
                genero = GeneroArtista(classificacao.genero.id, classificacao.genero.nome),
                subGenero = SubGeneroArtista(classificacao.subGenero.id, classificacao.subGenero.nome),
                tipo = TipoArtista(
                    classificacao.tipo?.id ?: "",
                    classificacao.tipo?.nome ?: "Undefined"
                ),
                subTipo = SubTipoArtista(
                    classificacao.subTipo?.id ?: "",
                    classificacao.subTipo?.nome ?: "Undefined"
                ),
                familia = classificacao.familia
            )
        }
        
        val proximosEventos = ProximosEventosArtista(
            ticketnet = atracao.proximosEventos.ticketnet,
            ticketmaster = atracao.proximosEventos.ticketmaster,
            mfxNo = atracao.proximosEventos.mfxNo,
            crowder = atracao.proximosEventos.crowder,
            total = atracao.proximosEventos.total,
            filtrado = atracao.proximosEventos.filtrado
        )
        
        return ArtistaInfo(
            nome = atracao.nome,
            id = atracao.id,
            url = atracao.url,
            tipo = atracao.tipo,
            linksExternos = linksExternos,
            imagens = imagensArtista,
            classificacoes = classificacoes,
            proximosEventos = proximosEventos
        )
    }
}
