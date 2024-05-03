package com.example.incrementapp

import android.graphics.Color
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class TextViewUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    val interaction = onView(
        allOf(
            withId(R.id.textNumber),
            isAssignableFrom(TextInputLayout::class.java),
            rootIdMatcher,
            rootClassMatcher

        )
    )


    fun Itinital() {
        interaction.check(withTextColor(Color.parseColor("#27D959")))
    }

    fun IncrementStart() {
        interaction.check(withTextColor(Color.parseColor("000000")))
    }

    fun Finish() {
        interaction.check(withTextColor(Color.parseColor("#EB1C1C")))
    }

}
