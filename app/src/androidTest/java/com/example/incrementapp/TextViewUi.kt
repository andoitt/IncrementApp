package com.example.incrementapp

import android.view.View
import androidx.test.espresso.Espresso.onView
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
        TODO("Not yet implemented")
    }

    fun Finish() {
        TODO("Not yet implemented")
    }

    fun IncrementStart() {
        TODO("Not yet implemented")
    }





}
