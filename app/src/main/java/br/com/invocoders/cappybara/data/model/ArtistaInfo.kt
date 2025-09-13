package br.com.invocoders.cappybara.data.model

data class ArtistaInfo(
    val nome: String,
    val id: String,
    val url: String,
    val tipo: String,
    val linksExternos: LinksExternos?,
    val imagens: List<String>,
    val classificacoes: List<ClassificacaoArtista>,
    val proximosEventos: ProximosEventosArtista
)

data class LinksExternos(
    val youtube: List<LinkExterno>?,
    val twitter: List<LinkExterno>?,
    val itunes: List<LinkExterno>?,
    val spotify: List<LinkExterno>?,
    val wiki: List<LinkExterno>?,
    val facebook: List<LinkExterno>?,
    val instagram: List<LinkExterno>?,
    val musicbrainz: List<LinkMusicBrainz>?
)

data class LinkExterno(
    val url: String
)

data class LinkMusicBrainz(
    val id: String,
    val url: String
)

data class ClassificacaoArtista(
    val primario: Boolean,
    val segmento: SegmentoArtista,
    val genero: GeneroArtista,
    val subGenero: SubGeneroArtista,
    val tipo: TipoArtista,
    val subTipo: SubTipoArtista,
    val familia: Boolean
)

data class SegmentoArtista(
    val id: String,
    val nome: String
)

data class GeneroArtista(
    val id: String,
    val nome: String
)

data class SubGeneroArtista(
    val id: String,
    val nome: String
)

data class TipoArtista(
    val id: String,
    val nome: String
)

data class SubTipoArtista(
    val id: String,
    val nome: String
)

data class ProximosEventosArtista(
    val ticketnet: Int,
    val ticketmaster: Int,
    val mfxNo: Int,
    val crowder: Int,
    val total: Int,
    val filtrado: Int
)
