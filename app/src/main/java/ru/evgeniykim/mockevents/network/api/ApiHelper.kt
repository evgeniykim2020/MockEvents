package ru.evgeniykim.mockevents.network.api

import kotlinx.coroutines.flow.Flow
import ru.evgeniykim.mockevents.models.EventsModel

interface ApiHelper {
    fun getEvents(): Flow<EventsModel>
}