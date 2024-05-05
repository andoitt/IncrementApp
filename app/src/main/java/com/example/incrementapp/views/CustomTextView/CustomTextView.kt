package com.example.incrementapp.views.CustomTextView

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.StringRes

class CustomTextView : androidx.appcompat.widget.AppCompatTextView, UpdateText {


    private lateinit var uiState: TextUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: TextUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun updateUi(incrementValue: Int, color: Int) {
        this.setText(incrementValue)
        this.text = incrementValue.toString()
        this.setTextColor(color)
    }


    override fun onSaveInstanceState(): Parcelable {
        super.onSaveInstanceState().let {
            val state = CustomTextViewSavedState(superState)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CustomTextViewSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}


interface UpdateText {
    fun updateUiState(outer: TextUiState)
    fun updateUi(incrementValue: Int, color: Int)


}