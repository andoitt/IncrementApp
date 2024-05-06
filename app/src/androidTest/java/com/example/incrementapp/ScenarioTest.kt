package com.example.incrementapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.incrementapp.presentation.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * TestCase number
 *
 *
 * 1.click Increment
 * check state - incrementStart
 * 2.click Increment 10 times
 * check state - incrementStart
 * check state - Finish state
 * 3.click reset
 * check state - Initial state
 */
@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get: Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun funCaseNumberOne() {
        var incrementPage = IncrementPage()

        incrementPage.checkStateInitial()
        scenarioRule.scenario.recreate()
        incrementPage.checkStateInitial()

        //1


        incrementPage = IncrementPage()

        //2
        repeat(9) {
            incrementPage.clickIncrement()
            val currentText = "${it + 1}"
            incrementPage.checkStateIncrementStart(value = it + 1)
            scenarioRule.scenario.recreate()
            incrementPage.checkStateIncrementStart(value = it + 1)
        }

        incrementPage = IncrementPage()

        incrementPage.checkStateFinish()
        scenarioRule.scenario.recreate()
        incrementPage.checkStateFinish()


        //3
        incrementPage.clickReset()
        incrementPage.checkStateInitial()
        scenarioRule.scenario.recreate()
        incrementPage.checkStateInitial()

    }
}