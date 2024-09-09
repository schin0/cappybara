package br.com.invocoders.cappybara.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.invocoders.cappybara.data.api.CategoriaEventoRetrofitFactory
import br.com.invocoders.cappybara.model.CategoriaEvento
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreferenciaViewModel : ViewModel() {
    private val _categoriaEvento = mutableStateOf<List<CategoriaEvento>>(emptyList())
    var categoriaEvento: State<List<CategoriaEvento>> = _categoriaEvento

    fun listarCategoriaEvento() {
        viewModelScope.launch {
            try {
                val call = CategoriaEventoRetrofitFactory().categoriaEventoRepository()
                    .listarCategoriaEvento()

                call.enqueue(object : Callback<List<CategoriaEvento>> {
                    override fun onResponse(
                        call: Call<List<CategoriaEvento>>,
                        response: Response<List<CategoriaEvento>>
                    ) {
                        if (response.isSuccessful) {
                            _categoriaEvento.value = response.body() ?: emptyList()
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

                    override fun onFailure(call: Call<List<CategoriaEvento>>, t: Throwable) {
                        Log.e("TesteAqui", t.message ?: "Erro desconhecido")
                    }
                })

            } catch (e: Exception) {
                Log.e("Erro1", e.message ?: "Erro desconhecido")
            }
        }
    }


}