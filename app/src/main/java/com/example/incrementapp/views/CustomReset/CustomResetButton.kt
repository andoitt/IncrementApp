package com.example.incrementapp.views.CustomReset

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton

class CustomResetButton : MaterialButton, UpdateResetButton {

    private lateinit var uiState: ResetUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )


    override fun onSaveInstanceState(): Parcelable {
        super.onSaveInstanceState().let {
            val state = CustomResetButtonSavedState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CustomResetButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }


    override fun updateUi(visibility: Boolean) {

        this.visibility = VISIBLE

    }

    override fun updateUiState(outer: ResetUiState) {
        uiState = outer
        uiState.show(this)

    }
}

    interface UpdateResetButton {

        fun updateUi(visibility: Boolean)
        fun updateUiState(outer: ResetUiState)
    }

