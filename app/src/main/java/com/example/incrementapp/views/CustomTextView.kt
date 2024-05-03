package com.example.incrementapp.views

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton

class CustomTextView : androidx.appcompat.widget.AppCompatTextView {

     constructor(context: Context) : super(context)
         constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
         constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
             context,
             attributeSet,
             defStyleAttrs
         )




}


interface TextAction {
    fun updateUiState : TextUiState(){

    }
}