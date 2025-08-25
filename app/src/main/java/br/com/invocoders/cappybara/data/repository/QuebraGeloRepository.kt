package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.model.QuebraGeloRequest
import br.com.invocoders.cappybara.model.QuebraGeloResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface QuebraGeloRepository {
    @POST("api/QuebraGelo/gerar")
    fun gerarIdeias(@Body request: QuebraGeloRequest): Call<QuebraGeloResponse>
}
