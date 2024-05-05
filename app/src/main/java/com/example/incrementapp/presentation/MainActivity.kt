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

        binding.incrementButton.setOnClickListener {
            uiState = viewModel.increment()
            uiState.update(
               updateIncrement = binding.incrementButton,
               updateReset = binding.resetButton,
               updateNumberTextView = binding.textNumber
            )

        }

        binding.resetButton.setOnClickListener {
            uiState = viewModel.reset()
            uiState.update(
                updateIncrement = binding.incrementButton,
                updateReset = binding.resetButton,
                updateNumberTextView = binding.textNumber
            )

        }


        uiState = viewModel.init(firstTime = savedInstanceState == null)
        uiState.update(
            updateIncrement = binding.incrementButton,
            updateReset = binding.resetButton,
            updateNumberTextView = binding.textNumber
        )
    }


}


