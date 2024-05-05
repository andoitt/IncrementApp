package com.example.incrementapp

import android.app.Application
import com.example.incrementapp.presentation.IncrementViewModel

class IncrementApp: Application() {

    lateinit var viewModel: IncrementViewModel

}