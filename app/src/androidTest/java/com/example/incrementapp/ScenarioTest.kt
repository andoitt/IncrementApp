package com.example.incrementapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
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

        checkStateInitial()
        scenarioRule.scenario.recreate()
        checkStateInitial()


        //1
        clickIncrement()
        checkStateIncrementStart()
        scenarioRule.scenario.recreate()
        checkStateIncrementStart()

        //2
        repeat(9) {
            val currentText = "${it + 1}"
            if (it == 1-9) {
                gamePage.checkStateIncrement(text = currentText)
                scenarioRule.scenario.recreate()
                gamePage.checkStateIncrement(text = currentText)
            } else if (it == 0){
                gamePage.checkStateInitial(text = currentText)
                scenarioRule.scenario.recreate()
                gamePage.checkStateInitial(text = currentText)
            } else {
                gamePage.checkStateFinish(text = currentText)
                scenarioRule.scenario.recreate()
                gamePage.checkStateFinish(text = currentText)
            }


        }

        checkStateFinish()
        scenarioRule.scenario.recreate()
        checkStateFinish()


        //3
        clickReset()
        checkStateInitшal()
        scenarioRule.scenario.recreate()
        checkStateInitial()
    }

}