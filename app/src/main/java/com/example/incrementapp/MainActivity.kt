package com.example.incrementapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.incrementapp.databinding.ActivityMainBinding

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
        }

        binding.resetButton.setOnClickListener {
            val uiState: Uistate = viewModel.reset()
            uiState.update(
                binding.incrementButton,
                binding.resetButton,
                binding.textNumber
            )
        }


        binding.textNumber.



        val uiState: Uistate = viewModel.numbersToText()
        uiState.update(
            binding.incrementButton,
            binding.resetButton,
            binding.textNumber
        )



        val uiState: Uistate = viewModel.init(savedInstanceState == null)
        uiState.update(
            binding.incrementButton,
            binding.resetButton,
            binding.textNumber
        )
    }

}

