package ru.evgeniykim.mockevents.network.api

import ru.evgeniykim.mockevents.interfaces.UiEffect
import ru.evgeniykim.mockevents.interfaces.UiEvent
import ru.evgeniykim.mockevents.interfaces.UiState
import ru.evgeniykim.mockevents.models.EventsModel

class MainContract {
    sealed class Event : UiEvent {
        object GetData : Event()
    }

    sealed class FetchingDataState {
        object Idle : FetchingDataState()
        object Loading : FetchingDataState()
        data class Success(val data: EventsModel) : FetchingDataState()
    }

    data class State(
        val fetchingData: FetchingDataState
    ) : UiState

    sealed class Effect : UiEffect {
        data class ShowError(val message: String) : Effect()
    }
}