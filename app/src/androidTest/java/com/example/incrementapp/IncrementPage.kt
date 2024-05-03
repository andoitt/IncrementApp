package com.example.incrementapp

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class IncrementPage {

    private val rootIdMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))
    private val rootClassMatcher: Matcher<View> = withParent(isAssignableFrom(LinearLayout::class.java))


    private val textView =
        TextViewUi(rootIdMatcher = rootIdMatcher , rootClassMatcher = rootClassMatcher)

    private val incrementButton =
        IncrementButtonUi(rootIdMatcher = rootIdMatcher , rootClassMatcher = rootClassMatcher)

    private val resetButton =
        ResetButtonUI(rootIdMatcher = rootIdMatcher , rootClassMatcher = rootClassMatcher)




    fun checkStateInitial() {
        textView.Itinital()
        incrementButton.Initial()
        resetButton.Initial()
    }

    fun clickIncrement() {
        incrementButton.click()
    }


    fun checkStateIncrementStart(text: String) {
        textView.IncrementStart()
        incrementButton.IncrementStart()
        resetButton.IncrementStart()
    }

    fun checkStateFinish() {
        textView.Finish()
        incrementButton.Finish()
        resetButton.Finish()
    }

    fun clickReset() {
        resetButton.click()
    }



}
