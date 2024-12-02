package ru.evgeniykim.mockevents.network.api

import retrofit2.http.GET
import ru.evgeniykim.mockevents.models.EventsModel

interface MyApi {
    @GET("1Z-UkYOJR2v7VLMwmnA0pVBUidxzPEnKA/view?usp=sharing")
    suspend fun getEvents(): EventsModel
}