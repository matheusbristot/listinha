package com.bristot.listinha

import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainFragmentInstrumentedTest {

    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun before() {
        hiltRule.inject()
    }

    @Test
    fun verify_first_fragment_opened() {
        open(R.id.mainFragment)
        check()
    }

    @Test
    fun verify_second_fragment_opened() {
        open(R.id.secondFragment)
        check()
    }

    private fun open(@IdRes fragmentId: Int) {
        launchFragment<MainActivity>(R.navigation.nav_graph, fragmentId)
    }

    private fun check() {
        onAssert(isDisplayed())
        onAssert(isCompletelyDisplayed())
    }

    private fun onAssert(matcher: Matcher<View>) {
        onView(withId(R.id.message)).check(matches(matcher))
    }
}
