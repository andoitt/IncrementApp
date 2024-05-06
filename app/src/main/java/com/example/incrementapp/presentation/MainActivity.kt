package com.example.incrementapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.incrementapp.IncrementApp
import com.example.incrementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.rootLayout)


        lateinit var uiState: UiState

        val viewModel: IncrementViewModel = (application as IncrementApp).viewModel


        val showUi: () -> Unit = {
            uiState.update(
                incrementButton = binding.incrementButton,
                resetButton = binding.resetButton,
                textNumber = binding.textNumber
            )
        }


        binding.incrementButton.setOnClickListener {
            uiState = viewModel.increment()
            showUi.invoke()

        }

        binding.resetButton.setOnClickListener {
            uiState = viewModel.reset()
            showUi.invoke()
        }


        uiState = viewModel.init(firstTime = savedInstanceState == null)
        showUi.invoke()
    }
}


