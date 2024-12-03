package ru.evgeniykim.mockevents.network.api

import retrofit2.http.GET
import ru.evgeniykim.mockevents.models.EventsModel

interface MyApi {
    @GET("")
    suspend fun getEvents(): EventsModel
}