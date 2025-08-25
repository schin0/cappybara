package br.com.invocoders.cappybara.core.services

import android.util.Log
import br.com.invocoders.cappybara.data.api.QuebraGeloRetrofitFactory
import br.com.invocoders.cappybara.model.QuebraGeloRequest
import br.com.invocoders.cappybara.model.QuebraGeloResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun gerarIdeiasQuebraGelo(
    request: QuebraGeloRequest,
    onSuccess: (QuebraGeloResponse) -> Unit,
    onError: (String) -> Unit
) {
    val call = QuebraGeloRetrofitFactory().quebraGeloRepository().gerarIdeias(request)

    call.enqueue(object : Callback<QuebraGeloResponse> {
        override fun onResponse(
            call: Call<QuebraGeloResponse>,
            response: Response<QuebraGeloResponse>
        ) {
            if (response.isSuccessful) {
                val resposta = response.body()
                if (resposta != null) {
                    onSuccess(resposta)
                } else {
                    onError("Resposta vazia da API")
                }
            } else {
                Log.e("QuebraGeloService", "Erro: ${response.code()}")
                onError("Erro na API: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<QuebraGeloResponse>, t: Throwable) {
            Log.e("QuebraGeloService", "Falha na requisição: ${t.message}")
            onError("Falha na conexão: ${t.message}")
        }
    })
}
