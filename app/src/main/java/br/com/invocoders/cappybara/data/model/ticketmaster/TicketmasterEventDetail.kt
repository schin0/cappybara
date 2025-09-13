package br.com.invocoders.cappybara.data.model.ticketmaster

import com.google.gson.annotations.SerializedName

data class TicketmasterEventDetail(
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
