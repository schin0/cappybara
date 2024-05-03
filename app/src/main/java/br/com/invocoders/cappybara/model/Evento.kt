package br.com.invocoders.cappybara.model

import com.google.android.gms.maps.model.LatLng

data class Evento(
    val id: Int,
    val imagemIds: List<Int>,
    val titulo: String,
    val descricao: String,
    val avaliacao: Float,
    val localizacao: LatLng,
)