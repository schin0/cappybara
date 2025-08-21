package br.com.invocoders.cappybara.data.api

import br.com.invocoders.cappybara.data.repository.QuebraGeloRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuebraGeloRetrofitFactory {
    fun quebraGeloRepository(): QuebraGeloRepository {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cappyai-api-2025-cjbqc4fngdbtcke5.brazilsouth-01.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(QuebraGeloRepository::class.java)
    }
}
