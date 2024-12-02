package ru.evgeniykim.mockevents.network.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.evgeniykim.mockevents.models.EventsModel

class ApiHelperImpl(private val api: MyApi) : ApiHelper {
    override fun getEvents(): Flow<EventsModel> = flow {
        emit(api.getEvents())
    }
}