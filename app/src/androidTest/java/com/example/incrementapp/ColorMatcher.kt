package com.example.incrementapp

import android.view.View
import android.widget.TextView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher


fun withTextColor(expectedId: Int): Matcher<in View>? {
    return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
        override fun matchesSafely(textView: TextView): Boolean {
            return expectedId == textView.currentTextColor
        }

        override fun describeTo(description: Description) {
            description.appendText("with text color: ")
            description.appendValue(expectedId)
        }
    }
}