package br.com.invocoders.cappybara.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.invocoders.cappybara.BuildConfig
import br.com.invocoders.cappybara.data.api.ClimaRetrofitFactory
import br.com.invocoders.cappybara.data.api.EventoRetrofitFactory
import br.com.invocoders.cappybara.data.model.EventoDetalhe
import br.com.invocoders.cappybara.data.model.EventoResumo
import br.com.invocoders.cappybara.model.Clima
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

    fun listarEventosProximos(latitude: Double, longitude: Double, itens: Int) {
        viewModelScope.launch {
            try {
                val raioEmKm = 100.0
                val call = EventoRetrofitFactory().eventoRepository()
                    .listarEventosProximos(latitude, longitude, raioEmKm, itens = itens)

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
        dataHoraTermino = "",
        imagens = emptyList(),
        clima = null
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
                            val eventoDetalhe = response.body()!!
                            _eventoDetalhe.value = eventoDetalhe

                            val lat = eventoDetalhe.latitude.toString()
                            val lon = eventoDetalhe.longitude.toString()

                            obterClima(eventoDetalhe, lat, lon)
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

    private fun obterClima(eventoDetalhe: EventoDetalhe, lat: String, lon: String) {
        val climaCall = ClimaRetrofitFactory().climaRetrofitFactory().obterClima(
            lat = lat,
            lon = lon,
            appid = BuildConfig.WEATHER_MAP_API_KEY
        )

        climaCall.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    val climaResponse = response.body() as Map<String, Any>

                    val weather = (climaResponse["weather"] as List<Map<String, Any>>)[0]
                    val main = climaResponse["main"] as Map<String, Any>

                    val iconeId = weather["icon"] as String
                    val descricao = weather["description"] as String
                    val temperaturaMin = (main["temp_min"] as Double) - 273.15
                    val temperaturaMax = (main["temp_max"] as Double) - 273.15

                    val (descricaoTraduzida, dica) = traduzirDescricaoClimaEFornecerDica(descricao)

                    val clima = Clima(
                        iconeId = iconeId,
                        temperaturaMin = temperaturaMin,
                        temperaturaMax = temperaturaMax,
                        descricao = descricaoTraduzida,
                        dica = dica
                    )

                    val eventoAtualizado = eventoDetalhe.copy(clima = clima)
                    _eventoDetalhe.value = eventoAtualizado

                    Log.d("Clima", "Clima adicionado ao evento: $clima")
                } else {
                    Log.e(
                        "ClimaErro",
                        "Código: ${response.code()}, Mensagem: ${response.message()}"
                    )
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.e("ClimaErro", t.message ?: "Erro desconhecido")
            }
        })
    }

    fun traduzirDescricaoClimaEFornecerDica(descricao: String): Pair<String, String> {
        return when (descricao) {
            "clear sky" -> Pair("Céu claro", "Lembre de passar o protetor solar")
            "few clouds", "scattered clouds" -> Pair(
                "Poucas nuvens",
                "Aproveite o dia, mas leve óculos de sol"
            )

            "broken clouds", "overcast clouds" -> Pair("Nublado", "Lembre de levar o casaco")

            "light rain", "moderate rain", "heavy intensity rain", "very heavy rain",
            "extreme rain", "freezing rain", "light intensity shower rain", "shower rain",
            "heavy intensity shower rain" -> Pair("Chuva", "Lembre de levar o guarda-chuva")

            "thunderstorm with light rain", "thunderstorm with rain",
            "thunderstorm with heavy rain", "light thunderstorm",
            "thunderstorm", "heavy thunderstorm", "ragged thunderstorm" ->
                Pair("Trovoada", "Evite sair de casa, trovoadas previstas")

            "light snow", "snow", "heavy snow", "sleet", "light shower sleet", "shower sleet" ->
                Pair("Neve", "Se agasalhe bem e tome cuidado com estradas escorregadias")

            "mist", "haze", "fog", "smoke" -> Pair(
                "Neblina",
                "Dirija com cuidado e use faróis de neblina"
            )

            "cold" -> Pair("Frio", "Vista roupas quentes, o clima está frio")
            "hot" -> Pair("Calor", "Lembre de se hidratar e usar roupas leves")

            "windy" -> Pair("Ventoso", "O vento está forte, cuidado com objetos soltos")
            "hail" -> Pair("Granizo", "Evite sair, granizo previsto")

            else -> Pair("Clima desconhecido", "Fique atento às condições meteorológicas")
        }
    }


}