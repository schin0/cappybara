package br.com.invocoders.cappybara.data.model.ticketmaster

import com.google.gson.annotations.SerializedName

data class TicketmasterResponse(
    @SerializedName("_embedded")
    val embedded: TicketmasterEmbeddedResponse,
    @SerializedName("_links")
    val links: TicketmasterResponseLinks,
    @SerializedName("page")
    val pagina: TicketmasterPage
)

data class TicketmasterEmbeddedResponse(
    @SerializedName("events")
    val eventos: List<TicketmasterEvent>
)

data class TicketmasterResponseLinks(
    @SerializedName("first")
    val primeiro: TicketmasterLink,
    @SerializedName("self")
    val self: TicketmasterLink,
    @SerializedName("next")
    val proximo: TicketmasterLink?,
    @SerializedName("last")
    val ultimo: TicketmasterLink
)

data class TicketmasterPage(
    @SerializedName("size")
    val tamanho: Int,
    @SerializedName("totalElements")
    val totalElementos: Int,
    @SerializedName("totalPages")
    val totalPaginas: Int,
    @SerializedName("number")
    val numero: Int
)
