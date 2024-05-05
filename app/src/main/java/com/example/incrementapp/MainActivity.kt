package com.example.incrementapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.incrementapp.databinding.ActivityMainBinding
import com.example.incrementapp.views.CustomTextView.CustomTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.rootLayout)


        val viewModel: MainViewModel = (application as App).viewModel

        binding.incrementButton.setOnClickListener {
            val uiState: Uistate = viewModel.increment()
            uiState.update(
                binding.incrementButton,
                binding.resetButton,
                binding.textNumber
            )
            updateCustomTextView(binding.textNumber, viewModel.getCurrentNumber())
        }

        binding.resetButton.setOnClickListener {
            val uiState: Uistate = viewModel.reset()
            uiState.update(
                binding.incrementButton,
                binding.resetButton,
                binding.textNumber
            )
            updateCustomTextView(binding.textNumber, viewModel.getCurrentNumber())

        }

        updateCustomTextView(binding.textNumber, viewModel.getCurrentNumber())



        val uiState: Uistate = viewModel.init(savedInstanceState == null)
        uiState.update(
            binding.incrementButton,
            binding.resetButton,
            binding.textNumber
        )
    }

    private fun updateCustomTextView(customTextView: CustomTextView, value: Int) {
        customTextView.text = value.toString()
    }

}


