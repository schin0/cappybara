package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventoRepository {
    @GET("listar-resumo-evento?pagina=0&itens=10")
    fun listarEventosDetalhes(): Call<List<EventoResumo>>

    @GET("listar-por-raio-km")
    fun listarEventosProximos(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("raioEmKm") raioEmKm: Double,
        @Query("pagina") pagina: Int = 0,
        @Query("itens") itens: Int = 5
    ): Call<List<EventoResumo>>

    @GET("listarPorId/{id}")
    fun obterPorId(@Path("id") id: Long): Call<EventoDetalhe>
}