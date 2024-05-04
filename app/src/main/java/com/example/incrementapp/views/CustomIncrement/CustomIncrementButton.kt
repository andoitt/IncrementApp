package com.example.incrementapp.views.CustomIncrement

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton

class CustomIncrementButton : MaterialButton, UpdateIncrementButton {


    private lateinit var uiState: IncrementUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )


    override fun onSaveInstanceState(): Parcelable {
        super.onSaveInstanceState().let {superState ->
            val state = CustomIncrementButtonSavedState(superState)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CustomIncrementButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }

    override fun updateUiState(outer: IncrementUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun updateUi(isEnable: Boolean) {
        this.isEnabled = isEnable
    }
}

interface UpdateIncrementButton {

    fun updateUiState(outer: IncrementUiState)
    fun updateUi(isEnable: Boolean)


}