package com.example.incrementapp.presentation

import com.example.incrementapp.views.CustomIncrement.CustomIncrementButton
import com.example.incrementapp.views.CustomIncrement.IncrementUiState
import com.example.incrementapp.views.CustomIncrement.UpdateIncrementButton
import com.example.incrementapp.views.CustomReset.CustomResetButton
import com.example.incrementapp.views.CustomReset.ResetUiState
import com.example.incrementapp.views.CustomReset.UpdateResetButton
import com.example.incrementapp.views.CustomTextView.CustomTextView
import com.example.incrementapp.views.CustomTextView.TextUiState
import com.example.incrementapp.views.CustomTextView.UpdateText

interface UiState {
    fun update(
        incrementButton: UpdateIncrementButton,
        resetButton: UpdateResetButton,
        textNumber: UpdateText
    )


    object Empty : UiState {

        override fun update(
            incrementButton: UpdateIncrementButton,
            resetButton: UpdateResetButton,
            textNumber: UpdateText
        ) = Unit


    }

    object Initial : UiState {
        override fun update(
            incrementButton: UpdateIncrementButton,
            resetButton: UpdateResetButton,
            textNumber: UpdateText
        ) {
            incrementButton.updateUiState(IncrementUiState.Initial)
            resetButton.updateUiState(ResetUiState.Initial)
            textNumber.updateUiState(TextUiState.Initial)
        }


    }

    object Finish : UiState {
        override fun update(
            incrementButton: UpdateIncrementButton,
            resetButton: UpdateResetButton,
            textNumber: UpdateText
        ) {
            incrementButton.updateUiState(IncrementUiState.Finish)
            resetButton.updateUiState(ResetUiState.Finish)
            textNumber.updateUiState(TextUiState.Finish)
        }


    }

    data class IncrementStart(private val it: Int) : UiState {
        override fun update(
            incrementButton: UpdateIncrementButton,
            resetButton: UpdateResetButton,
            textNumber: UpdateText
        ) {
            incrementButton.updateUiState(IncrementUiState.Increment)
            resetButton.updateUiState(ResetUiState.Increment)
            textNumber.updateUiState(TextUiState.Increment(it))

        }
    }
}