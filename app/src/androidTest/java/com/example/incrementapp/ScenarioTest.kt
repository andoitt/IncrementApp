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
        val incrementPage = IncrementPage()

       checkStateInital()


        //1
        clickIncrement()
        checkStateIncrementStart()
        scenarioRule.scenario.recreate()
        checkStateIncrementStart()

        //2
        repeat(10){
            clickIncrement()
            checkStateFinishState()
            scenarioRule.scenario.recreate()
            checkStateFinishState()
        }

        //3
        clickReset()
        checkStateInital()
        scenarioRule.scenario.recreate()
        checkStateInital()


    }
}