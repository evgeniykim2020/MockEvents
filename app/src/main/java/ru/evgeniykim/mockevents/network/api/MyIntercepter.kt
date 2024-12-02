package ru.evgeniykim.mockevents.network.api

import okhttp3.Interceptor
import okhttp3.Response

class MyIntercepter: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .build()

        return chain.proceed(request)
    }
}