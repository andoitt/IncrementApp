package com.example.incrementapp.presentation

import com.example.incrementapp.views.CustomIncrement.CustomIncrementButton
import com.example.incrementapp.views.CustomReset.CustomResetButton
import com.example.incrementapp.views.CustomTextView.CustomTextView

interface UiState {
    fun update(
        updateIncrement: CustomIncrementButton,
        updateReset: CustomResetButton,
        updateNumberTextView: CustomTextView
    )


    object Empty : UiState {

        override fun update(
            updateIncrement: CustomIncrementButton,
            updateReset: CustomResetButton,
            updateNumberTextView: CustomTextView
        ) = Unit


    }

    object Initial : UiState {
        override fun update(
            updateIncrement: CustomIncrementButton,
            updateReset: CustomResetButton,
            updateNumberTextView: CustomTextView
        ) {
            TODO("Not yet implemented")
        }

    }

    object Finish : UiState {
        override fun update(
            updateIncrement: CustomIncrementButton,
            updateReset: CustomResetButton,
            updateNumberTextView: CustomTextView
        ) {
            TODO("Not yet implemented")
        }


    }

    data class IncrementStart(private val it: Int) : UiState {
        override fun update(
            updateIncrement: CustomIncrementButton,
            updateReset: CustomResetButton,
            updateNumberTextView: CustomTextView
        ) {
            TODO("Not yet implemented")
        }


    }


}