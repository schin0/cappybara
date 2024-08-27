package br.com.invocoders.cappybara.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.invocoders.cappybara.data.api.EventoRetrofitFactory
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventoViewModel : ViewModel() {
    private val _eventosDetalhes = mutableStateOf<List<EventoResumo>>(emptyList())
    var eventosDetalhes: State<List<EventoResumo>> = _eventosDetalhes

    fun listarEventosDetalhes() {
        viewModelScope.launch {
            try {
                val call = EventoRetrofitFactory().eventoRepository().listarEventosDetalhes()

                call.enqueue(object : Callback<List<EventoResumo>> {
                    override fun onResponse(
                        call: Call<List<EventoResumo>>,
                        response: Response<List<EventoResumo>>
                    ) {
                        if (response.isSuccessful) {
                            _eventosDetalhes.value = response.body() ?: emptyList()
                        } else {
                            Log.e(
                                "TesteAqui",
                                "Código: ${response.code()}, Mensagem: ${response.message()}"
                            )
                            response.errorBody()?.let { errorBody ->
                                Log.e("TesteAqui", errorBody.string())
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<EventoResumo>>, t: Throwable) {
                        Log.e("TesteAqui", t.message ?: "Erro desconhecido")
                    }
                })

            } catch (e: Exception) {
                Log.e("Erro1", e.message ?: "Erro desconhecido")
            }
        }
    }

    private val _eventosProximos = mutableStateOf<List<EventoResumo>>(emptyList())
    var eventosProximos: State<List<EventoResumo>> = _eventosProximos

    fun listarEventosProximos(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                val raioEmKm = 100.0
                val call = EventoRetrofitFactory().eventoRepository()
                    .listarEventosProximos(latitude, longitude, raioEmKm)

                call.enqueue(object : Callback<List<EventoResumo>> {
                    override fun onResponse(
                        call: Call<List<EventoResumo>>,
                        response: Response<List<EventoResumo>>
                    ) {
                        if (response.isSuccessful) {
                            _eventosProximos.value = response.body() ?: emptyList()
                        } else {
                            Log.e(
                                "TesteAqui",
                                "Código: ${response.code()}, Mensagem: ${response.message()}"
                            )
                            response.errorBody()?.let { errorBody ->
                                Log.e("TesteAqui", errorBody.string())
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<EventoResumo>>, t: Throwable) {
                        Log.e("TesteAqui", t.message ?: "Erro desconhecido")
                    }
                })

            } catch (e: Exception) {
                Log.e("Erro1", e.message ?: "Erro desconhecido")
            }
        }
    }

    val eventoDetalhePadrao = EventoDetalhe(
        id = 0L,
        titulo = "",
        descricao = "",
        latitude = 0.0,
        longitude = 0.0,
        categoriaEvento = 0L,
        preco = 0.0,
        artistas = "",
        dataHoraInicio = "",
        imagens = emptyList()
    )
    private val _eventoDetalhe = mutableStateOf(eventoDetalhePadrao)
    var eventoDetalhe: State<EventoDetalhe> = _eventoDetalhe

    fun obterEventoDetalhePorId(id: Long) {
        viewModelScope.launch {
            try {
                val call = EventoRetrofitFactory().eventoRepository().obterPorId(id)

                call.enqueue(object : Callback<EventoDetalhe> {
                    override fun onResponse(
                        call: Call<EventoDetalhe>,
                        response: Response<EventoDetalhe>
                    ) {
                        if (response.isSuccessful) {
                            _eventoDetalhe.value = response.body()!!
                        } else {
                            Log.e(
                                "TesteAqui",
                                "Código: ${response.code()}, Mensagem: ${response.message()}"
                            )
                            response.errorBody()?.let { errorBody ->
                                Log.e("TesteAqui", errorBody.string())
                            }
                        }
                    }

                    override fun onFailure(call: Call<EventoDetalhe>, t: Throwable) {
                        Log.e("TesteAqui", t.message ?: "Erro desconhecido")
                    }
                })

            } catch (e: Exception) {
                Log.e("Erro1", e.message ?: "Erro desconhecido")
            }
        }
    }
}