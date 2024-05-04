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
        textView.initial()
        incrementButton.initial()
        resetButton.initial()
    }

    fun clickIncrement() {
        incrementButton.click()
    }


    fun checkStateIncrementStart(text: String) {
        textView.incrementStart()
        incrementButton.incrementStart()
        resetButton.incrementStart()
    }

    fun checkStateFinish() {
        textView.finish()
        incrementButton.finish()
        resetButton.finish()
    }

    fun clickReset() {
        resetButton.click()
    }



}
