package com.example.incrementapp

import com.example.incrementapp.data.Repository
import com.example.incrementapp.presentation.IncrementViewModel
import com.example.incrementapp.presentation.UiState
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 *
 */
class IncrementViewModelTest {

    private lateinit var viewModel: IncrementViewModel
    private lateinit var repository: FakeRepository

    private lateinit var actual: UiState
    private lateinit var expected: UiState


    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = IncrementViewModel(
            repository = repository
        )
    }

    @Test
    fun caseNumberOne() {


        actual = viewModel.init(firstTime = true)
        expected = UiState.Initial

        assertEquals(expected, actual)

        repeat(9) {
            actual = viewModel.increment()
            expected = UiState.IncrementStart(it + 1)
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

class FakeRepository : Repository {

    private var counter: Int = 0

    override fun isMax(): Boolean = counter == 10


    override fun increment() {
        counter++
    }

    override fun reset() {
        counter = 0
    }

    override fun getIncrement(): Int = counter

}