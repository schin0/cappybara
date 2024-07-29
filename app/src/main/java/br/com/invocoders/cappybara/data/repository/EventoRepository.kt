package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.data.model.EventoDetalhe
import retrofit2.Call
import retrofit2.http.GET

interface EventoRepository {
    @GET("listar-resumo-evento?pagina=0&itens=10")
    fun listarEventosDetalhes(): Call<List<EventoDetalhe>>
}