package com.example.incrementapp.views.CustomTextView

import com.example.incrementapp.R

interface TextUiState {

    fun show(customTextView: UpdateText)

    abstract class Abstract(private val incrementValue: Int, private val color: Int) :
        TextUiState {
        override fun show(customTextView: UpdateText) {
            customTextView.updateUi(incrementValue = incrementValue, color = color)
        }
    }

    object Initial : Abstract(0, R.color.green)

    data class Increment(private val value: Int) : Abstract(incrementValue = value, R.color.black)
    object Reset : Abstract(10,R.color.red)

}
