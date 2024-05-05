package com.example.incrementapp

import com.example.incrementapp.presentation.IncrementViewModel
import com.example.incrementapp.presentation.UiState
import org.junit.Test

import org.junit.Assert.*

/**
 *
 */
class IncrementViewModelTest {
    @Test
    fun caseNumberOne() {

        val viewModel: IncrementViewModel = IncrementViewModel()

        var actual: UiState = viewModel.init(firstTime = true)
        var expected: UiState = UiState.Initial

        assertEquals(expected, actual)

        repeat(9){
            actual = viewModel.increment()
            expected = UiState.IncrementStart( + 1)
            assertEquals(expected, actual)
        }

        actual = viewModel.increment()
        expected = UiState.Finish
        assertEquals(expected, actual)

        actual = viewModel.reset()
        expected = UiState.Initial
        assertEquals(expected, actual)
    }
}