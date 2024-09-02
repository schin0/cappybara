package br.com.invocoders.cappybara.core.services

import com.google.android.gms.maps.model.LatLng
import com.google.gson.JsonArray

class RotaService {
    fun listarRotas(rotaJson: JsonArray): List<List<LatLng>> {
        val rotas = mutableListOf<List<LatLng>>()
        rotaJson.forEach { it ->
            val rota = mutableListOf<LatLng>()
            it.asJsonObject.getAsJsonArray("legs").forEach { it ->
                it.asJsonObject.getAsJsonArray("steps").forEach {
                    rota.addAll(
                        decodePoly(
                            it.asJsonObject.getAsJsonObject("polyline").get("points").asString
                        )
                    )
                }
            }
            rotas.add(rota)
        }
        return rotas
    }

    fun listarDuracoes(rotaJson: JsonArray): List<String> {
        val duracoes = mutableListOf<String>()
        rotaJson.forEach { routeElement ->
            routeElement.asJsonObject.getAsJsonArray("legs").forEach { legElement ->
                val duracaoTexto = legElement
                    .asJsonObject
                    .getAsJsonObject("duration")
                    .get("text")
                    .asString
                duracoes.add(duracaoTexto)
            }
        }
        return duracoes
    }

    fun listarDistancias(rotasJsonArray: JsonArray): List<String> {
        val distancias = mutableListOf<String>()
        for (rota in rotasJsonArray) {
            val legs = rota.asJsonObject.getAsJsonArray("legs")
            for (leg in legs) {
                val distancia = leg.asJsonObject.getAsJsonObject("distance").get("text").asString
                distancias.add(distancia)
            }
        }
        return distancias
    }


    private fun decodePoly(encoded: String): List<LatLng> {
        val poly: MutableList<LatLng> = ArrayList()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0
        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat
            shift = 0
            result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng
            val p = LatLng(
                lat.toDouble() / 1E5,
                lng.toDouble() / 1E5
            )
            poly.add(p)
        }
        return poly
    }
}