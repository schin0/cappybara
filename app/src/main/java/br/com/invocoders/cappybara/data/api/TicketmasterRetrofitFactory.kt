package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.BuildConfig
import br.com.invocoders.cappybara.data.repository.TicketmasterRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TicketmasterRetrofitFactory {
    private val URL = "https://app.ticketmaster.com/"

    private val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun ticketmasterRepository(): TicketmasterRepository {
        return retrofitFactory.create(TicketmasterRepository::class.java)
    }
    
    fun obterChaveApi(): String {
        return BuildConfig.TICKETMASTER_API_KEY
    }
}
