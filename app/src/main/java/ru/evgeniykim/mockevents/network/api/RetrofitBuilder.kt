package ru.evgeniykim.mockevents.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = ""

    private val httpClient = OkHttpClient()

    private fun getRetrofit(): Retrofit {

        httpClient
            .newBuilder()
            .addInterceptor(MyIntercepter())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofitApiService: MyApi = getRetrofit().create(MyApi::class.java)
}