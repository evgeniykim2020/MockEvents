package ru.evgeniykim.mockevents.ui.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.evgeniykim.mockevents.network.api.ApiHelperImpl
import ru.evgeniykim.mockevents.network.api.MainContract
import ru.evgeniykim.mockevents.network.api.RetrofitBuilder

class MainViewModel: BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    private val apiHelper = ApiHelperImpl(RetrofitBuilder.retrofitApiService)

    override fun createInitialState(): MainContract.State {
        return MainContract.State(fetchingData = MainContract.FetchingDataState.Idle)
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.GetData -> getData()
        }
    }

    private fun getData() {
        viewModelScope.launch {
            setState { copy(fetchingData = MainContract.FetchingDataState.Loading) }
            try {
                apiHelper.getEvents().collect {
                    if (it.events.isNotEmpty()) {
                        setState { copy(fetchingData = MainContract.FetchingDataState.Success(data = it)) }
                    } else {
                        setEffect { MainContract.Effect.ShowError(message = "Error fetch data") }
                    }
                }
            } catch (e: Exception) {
                setEffect { MainContract.Effect.ShowError(message = e.message.toString()) }
            }
        }
    }
}