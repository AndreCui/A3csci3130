package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class CreateContactTest{

    @Rule
    public ActivityTestRule<MainActivity> activityRule=new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void createTest()throws InterruptedException{
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("BOB"),closeSoftKeyboard());
        onView(withId(R.id.businessnumber)).perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.primarybusiness)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("1515 Green St"),closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.name)).check(matches(withText("BOB")));
        onView(withId(R.id.businessnumber)).check(matches(withText("12345")));
        onView(withId(R.id.primarybusiness)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("1515 Green St")));
        onView(withId(R.id.province)).check(matches(withText("NS")));




    }
}