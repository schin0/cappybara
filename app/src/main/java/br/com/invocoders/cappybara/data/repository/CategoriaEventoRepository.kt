package br.com.invocoders.cappybara.data.repository

import br.com.invocoders.cappybara.model.CategoriaEvento
import retrofit2.Call
import retrofit2.http.GET

interface CategoriaEventoRepository {
    @GET("listar")
    fun listarCategoriaEvento(): Call<List<CategoriaEvento>>
}