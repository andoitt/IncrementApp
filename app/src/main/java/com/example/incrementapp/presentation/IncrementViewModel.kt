package com.example.incrementapp.presentation

import com.example.incrementapp.data.Repository

class IncrementViewModel(
    private val repository: Repository
) {

    fun init(firstTime: Boolean = true): UiState {
        return if (firstTime)
            UiState.Initial
        else
            UiState.Empty
    }

    fun increment(): UiState {
        repository.increment()
        return if (repository.isMax())
            UiState.Finish
        else
            UiState.IncrementStart(repository.getIncrement())
    }

    fun reset(): UiState {
        repository.reset()
        return UiState.Initial
    }

}
