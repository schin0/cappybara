package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.data.model.ticketmaster.TicketmasterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketmasterRepository {
    @GET("discovery/v2/events.json")
    fun listarEventos(
        @Query("size") tamanho: Int = 50,
        @Query("latlong") latlong: String,
        @Query("radius") raio: Int = 100,
        @Query("startDateTime") dataHoraInicio: String,
        @Query("unit") unidade: String = "km",
        @Query("sort") ordenacao: String? = null,
        @Query("apikey") chaveApi: String
    ): Call<TicketmasterResponse>
}
