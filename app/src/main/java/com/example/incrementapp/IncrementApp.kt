package com.example.incrementapp

import android.app.Application
import android.content.Context
import com.example.incrementapp.data.IntCache
import com.example.incrementapp.data.Repository
import com.example.incrementapp.presentation.IncrementViewModel

class IncrementApp: Application() {

    lateinit var viewModel: IncrementViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = IncrementViewModel(
            Repository.Base(
                IntCache.Base(this)

            )
        )
    }
}