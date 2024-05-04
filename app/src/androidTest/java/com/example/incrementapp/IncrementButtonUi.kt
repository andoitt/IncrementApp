package com.example.incrementapp

import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class IncrementButtonUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    val interaction = onView(
        allOf(
            withId(R.id.IncrementButton),
            isAssignableFrom(Button::class.java),
            rootIdMatcher,
            rootClassMatcher

        )
    )
    fun initial() {
        interaction.check(matches(isEnabled()))
    }


    fun incrementStart() {
        interaction.check(matches(isEnabled()))
    }

    fun finish() {
        interaction.check(matches(isDisplayed()))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }

}
