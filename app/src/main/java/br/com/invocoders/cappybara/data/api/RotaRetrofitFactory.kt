package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.RotaRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RotaRetrofitFactory {
    private val URL = "https://maps.googleapis.com/maps/api/directions/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    fun rotaRetrofitFactory() : RotaRepository {
        return retrofitFactory.create(RotaRepository::class.java)
    }
}