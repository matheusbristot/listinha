package com.bristot.listinha

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.findNavController
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule(order = 1)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun before() {
        hiltRule.inject()
    }

    @Test
    fun testFirstFragmentOpened() {

        rule.scenario.onActivity { activity ->
            val graph = activity.findNavController(R.id.nav_host_fragment).graph
            assert(graph.id == R.id.nav_graph)
            assert(graph.findStartDestination().id == R.id.mainFragment)
        }
    }
}