package br.com.invocoders.cappybara.data.model.ticketmaster

import com.google.gson.annotations.SerializedName

data class TicketmasterEvent(
    @SerializedName("name")
    val nome: String,
    @SerializedName("type")
    val tipo: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("test")
    val teste: Boolean,
    @SerializedName("url")
    val url: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("images")
    val imagens: List<TicketmasterImage>,
    @SerializedName("distance")
    val distancia: Double?,
    @SerializedName("units")
    val unidades: String?,
    @SerializedName("sales")
    val vendas: TicketmasterSales?,
    @SerializedName("dates")
    val datas: TicketmasterDates,
    @SerializedName("classifications")
    val classificacoes: List<TicketmasterClassification>,
    @SerializedName("_links")
    val links: TicketmasterLinks,
    @SerializedName("_embedded")
    val embedded: TicketmasterEmbedded
)

data class TicketmasterImage(
    @SerializedName("ratio")
    val proporcao: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val largura: Int,
    @SerializedName("height")
    val altura: Int,
    @SerializedName("fallback")
    val fallback: Boolean
)

data class TicketmasterSales(
    @SerializedName("public")
    val publico: TicketmasterPublicSales
)

data class TicketmasterPublicSales(
    @SerializedName("startDateTime")
    val dataHoraInicio: String,
    @SerializedName("startTBD")
    val inicioTBD: Boolean,
    @SerializedName("startTBA")
    val inicioTBA: Boolean
)

data class TicketmasterDates(
    @SerializedName("start")
    val inicio: TicketmasterStartDate,
    @SerializedName("timezone")
    val fusoHorario: String,
    @SerializedName("status")
    val status: TicketmasterStatus,
    @SerializedName("spanMultipleDays")
    val abrangeMultiplosDias: Boolean
)

data class TicketmasterStartDate(
    @SerializedName("localDate")
    val dataLocal: String,
    @SerializedName("localTime")
    val horaLocal: String?,
    @SerializedName("dateTime")
    val dataHora: String,
    @SerializedName("dateTBD")
    val dataTBD: Boolean,
    @SerializedName("dateTBA")
    val dataTBA: Boolean,
    @SerializedName("timeTBA")
    val horaTBA: Boolean,
    @SerializedName("noSpecificTime")
    val semHoraEspecifica: Boolean
)

data class TicketmasterStatus(
    @SerializedName("code")
    val codigo: String
)

data class TicketmasterClassification(
    @SerializedName("primary")
    val primario: Boolean,
    @SerializedName("segment")
    val segmento: TicketmasterSegment,
    @SerializedName("genre")
    val genero: TicketmasterGenre,
    @SerializedName("subGenre")
    val subGenero: TicketmasterSubGenre,
    @SerializedName("type")
    val tipo: TicketmasterType?,
    @SerializedName("subType")
    val subTipo: TicketmasterSubType?,
    @SerializedName("family")
    val familia: Boolean
)

data class TicketmasterSegment(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val nome: String
)

data class TicketmasterGenre(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val nome: String
)

data class TicketmasterSubGenre(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val nome: String
)

data class TicketmasterType(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val nome: String
)

data class TicketmasterSubType(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val nome: String
)

data class TicketmasterLinks(
    @SerializedName("self")
    val self: TicketmasterLink,
    @SerializedName("attractions")
    val atracoes: List<TicketmasterLink>,
    @SerializedName("venues")
    val locais: List<TicketmasterLink>
)

data class TicketmasterLink(
    @SerializedName("href")
    val href: String
)

data class TicketmasterEmbedded(
    @SerializedName("venues")
    val locais: List<TicketmasterVenue>,
    @SerializedName("attractions")
    val atracoes: List<TicketmasterAttraction>
)

data class TicketmasterVenue(
    @SerializedName("name")
    val nome: String,
    @SerializedName("type")
    val tipo: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("test")
    val teste: Boolean,
    @SerializedName("url")
    val url: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("distance")
    val distancia: Double?,
    @SerializedName("units")
    val unidades: String?,
    @SerializedName("postalCode")
    val codigoPostal: String?,
    @SerializedName("timezone")
    val fusoHorario: String,
    @SerializedName("city")
    val cidade: TicketmasterCity,
    @SerializedName("state")
    val estado: TicketmasterState,
    @SerializedName("country")
    val pais: TicketmasterCountry,
    @SerializedName("address")
    val endereco: TicketmasterAddress,
    @SerializedName("location")
    val localizacao: TicketmasterLocation,
    @SerializedName("upcomingEvents")
    val proximosEventos: TicketmasterUpcomingEvents,
    @SerializedName("_links")
    val links: TicketmasterLinks
)

data class TicketmasterCity(
    @SerializedName("name")
    val nome: String
)

data class TicketmasterState(
    @SerializedName("name")
    val nome: String,
    @SerializedName("stateCode")
    val codigoEstado: String
)

data class TicketmasterCountry(
    @SerializedName("name")
    val nome: String,
    @SerializedName("countryCode")
    val codigoPais: String
)

data class TicketmasterAddress(
    @SerializedName("line1")
    val linha1: String
)

data class TicketmasterLocation(
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("latitude")
    val latitude: String
)

data class TicketmasterUpcomingEvents(
    @SerializedName("ticketnet")
    val ticketnet: Int,
    @SerializedName("ticketmaster")
    val ticketmaster: Int,
    @SerializedName("mfx-no")
    val mfxNo: Int,
    @SerializedName("crowder")
    val crowder: Int,
    @SerializedName("_total")
    val total: Int,
    @SerializedName("_filtered")
    val filtrado: Int
)

data class TicketmasterAttraction(
    @SerializedName("name")
    val nome: String,
    @SerializedName("type")
    val tipo: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("test")
    val teste: Boolean,
    @SerializedName("url")
    val url: String,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("externalLinks")
    val linksExternos: TicketmasterExternalLinks?,
    @SerializedName("images")
    val imagens: List<TicketmasterImage>,
    @SerializedName("classifications")
    val classificacoes: List<TicketmasterClassification>,
    @SerializedName("upcomingEvents")
    val proximosEventos: TicketmasterUpcomingEvents,
    @SerializedName("_links")
    val links: TicketmasterLinks
)

data class TicketmasterExternalLinks(
    @SerializedName("youtube")
    val youtube: List<TicketmasterExternalLink>?,
    @SerializedName("twitter")
    val twitter: List<TicketmasterExternalLink>?,
    @SerializedName("itunes")
    val itunes: List<TicketmasterExternalLink>?,
    @SerializedName("spotify")
    val spotify: List<TicketmasterExternalLink>?,
    @SerializedName("wiki")
    val wiki: List<TicketmasterExternalLink>?,
    @SerializedName("facebook")
    val facebook: List<TicketmasterExternalLink>?,
    @SerializedName("instagram")
    val instagram: List<TicketmasterExternalLink>?,
    @SerializedName("musicbrainz")
    val musicbrainz: List<TicketmasterMusicBrainzLink>?
)

data class TicketmasterExternalLink(
    @SerializedName("url")
    val url: String
)

data class TicketmasterMusicBrainzLink(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String
)
