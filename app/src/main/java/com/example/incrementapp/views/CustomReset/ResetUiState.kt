package com.example.incrementapp.views.CustomReset

import com.example.incrementapp.views.CustomReset.CustomResetButton

interface ResetUiState {

    fun show(customResetButton: UpdateResetButton) {}

    abstract class Abstract(private val isVisible: Boolean) : ResetUiState {
        override fun show(customResetButton: UpdateResetButton) {
            customResetButton.updateUi(visibility = isVisible)
        }
    }

    object Initial : Abstract(isVisible = false)
    object Increment : Abstract(isVisible = false)
    object Finish : Abstract(isVisible = true)

}