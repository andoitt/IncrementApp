package com.example.incrementapp.views.CustomReset

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import com.example.incrementapp.views.CustomIncrement.IncrementUiState

class CustomResetButtonSavedState : View.BaseSavedState {

    private lateinit var state: ResetUiState


    constructor(superState: Parcelable) : super(superState)
    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            parcelIn.readSerializable(
                ResetUiState::class.java.classLoader,
                ResetUiState::class.java
            ) as ResetUiState
        } else {
            parcelIn.readSerializable() as ResetUiState
        }
    }

    fun save(uiState: ResetUiState) {
        state = uiState
    }

    fun restore(): ResetUiState = state

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<CustomResetButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): CustomResetButtonSavedState =
            CustomResetButtonSavedState(parcel)

        override fun newArray(size: Int): Array<CustomResetButtonSavedState?> =
            arrayOfNulls(size)
    }
}