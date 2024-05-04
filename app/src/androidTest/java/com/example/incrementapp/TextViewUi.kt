package com.example.incrementapp

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class TextViewUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    val interaction = onView(
        allOf(
            withId(R.id.textNumber),
            isAssignableFrom(TextView::class.java),
            rootIdMatcher,
            rootClassMatcher

        )
    )


    fun initial() {
        interaction
            .check(matches(withTextColor(R.color.green)))
            .check(matches(withText("0")))
    }

    fun incrementStart() {
        interaction
            .check(matches(withTextColor(R.color.black)))
            .check(matches(withText(click().toString())))
    }

    fun finish() {
        interaction
            .check(matches(withTextColor(R.color.red)))
            .check(matches(withText("10")))
    }



}
