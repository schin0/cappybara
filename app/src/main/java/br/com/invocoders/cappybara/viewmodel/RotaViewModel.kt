package br.com.invocoders.cappybara.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.invocoders.cappybara.core.services.RotaService
import br.com.invocoders.cappybara.data.api.RotaRetrofitFactory
import com.google.android.gms.maps.model.LatLng
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class RotaViewModel : ViewModel() {
    private val _rotas = MutableLiveData<List<List<LatLng>>>()
    val rotas: LiveData<List<List<LatLng>>>
        get() = _rotas

    private val _tempoRota = MutableLiveData<String?>()
    val tempoRota: MutableLiveData<String?> get() = _tempoRota

    private val _distanciaRota = MutableLiveData<String?>()
    val distanciaRota: MutableLiveData<String?> get() = _distanciaRota

    fun obterRota(
        key: String,
        localizacaoAtual: LatLng,
        localizacaoEvento: LatLng,
        deveConsiderarAlternativas: Boolean,
        modo: String
    ) {
        val tag = "Erro Rota:"

        viewModelScope.launch {
            try {
                val rotaApi = RotaRetrofitFactory().rotaRetrofitFactory()

                val request = rotaApi.getRoute(
                    "${localizacaoAtual.latitude},${localizacaoAtual.longitude}",
                    "${localizacaoEvento.latitude},${localizacaoEvento.longitude}",
                    key, deveConsiderarAlternativas, modo
                )
                val retorno = CoroutineScope(Dispatchers.IO).async {
                    if (request.isSuccessful)
                        return@async request.body()

                    return@async request.message()
                }.await()

                if (retorno is ResponseBody) {
                    val json = JsonParser().parse(retorno.string()).asJsonObject

                    if (json.get("status").asString == "OK") {
                        CoroutineScope(Dispatchers.IO).launch {
                            val rotasJsonArray = json.getAsJsonArray("routes")
                            val rotaService = RotaService()
                            val rotas = rotaService.listarRotas(rotasJsonArray)
                            val duracoes = rotaService.listarDuracoes(rotasJsonArray)
                            val distancias = rotaService.listarDistancias(rotasJsonArray)

                            val tempoRota = duracoes.firstOrNull()
                            val distanciaRota = distancias.firstOrNull()

                            _rotas.postValue(rotas)
                            _tempoRota.postValue(tempoRota)
                            _distanciaRota.postValue(distanciaRota)
                        }
                    } else {
                        Log.i(tag, json.get("status").asString)
                    }
                } else if (retorno is String) {
                    Log.i(tag, retorno)
                }
            } catch (e: Exception) {
                Log.i(tag, e.message ?: "")
            }
        }
    }
}