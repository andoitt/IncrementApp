package com.example.incrementapp.views.CustomIncrement

import java.io.Serializable

interface IncrementUiState: Serializable {
     fun show (customIncrementButton: UpdateIncrementButton) {}


    abstract class Abstract(private val isEnabled: Boolean): IncrementUiState {
        override fun show(customIncrementButton: UpdateIncrementButton) {
            customIncrementButton.updateUi(isEnable = isEnabled)
        }
    }

    object Initial: Abstract(isEnabled = true)
    object Increment: Abstract(isEnabled = true)
    object Finish: Abstract(isEnabled = false)

}