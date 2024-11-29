package com.example.madt_lab2;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import android.content.Context;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    /*
    Test rule that should be applied to all the test methods in the test class
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    /*
    Test to ensure that the app under test is correctly set up and verify
    that the package name of the app matches the expected value
     */
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.madt_lab2", appContext.getPackageName());
    }

    /*
    Test to ensure that count chars works well
     */
    @Test
    public void testCountCharacters() {
        // Input text
        onView(withId(R.id.userInput)).perform(replaceText("Hello"));

        // Select "Character Count" option (assuming it's default)
        onView(withId(R.id.showResult)).perform(click());

        // Verify the result
        onView(withId(R.id.resultCount)).check(matches(withText("5")));
    }

    /*
    Test to probe that the option count words works well
     */
    @Test
    public void testCountWords() {
        // Input text
        onView(withId(R.id.userInput)).perform(replaceText("Hello World"));

        // Select "Word Count" option
        onView(withId(R.id.countOption)).perform(click()); // Open the spinner
        onView(withText("Words")).perform(click());   // Select the "Words" option

        // Click the button
        onView(withId(R.id.showResult)).perform(click());

        // Verify the result
        onView(withId(R.id.resultCount)).check(matches(withText("2")));
    }




}