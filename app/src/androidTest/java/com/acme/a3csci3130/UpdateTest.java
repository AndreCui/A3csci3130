package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static android.support.test.espresso.action.ViewActions.typeText;

public class UpdateTest{
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void update() throws InterruptedException{
        Thread.sleep(1000);

        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("BOB"),closeSoftKeyboard());
        onView(withId(R.id.businessnumber)).perform(typeText("12345"),closeSoftKeyboard());
        onView(withId(R.id.primarybusiness)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("1515 Green St"),closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(2000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        Thread.sleep(2000);

        onView(withId(R.id.name)).perform(replaceText("TOM"));
        onView(withId(R.id.businessnumber)).perform(replaceText("12345789"));
        onView(withId(R.id.primarybusiness)).perform(replaceText("Fisher"));
        onView(withId(R.id.address)).perform(replaceText("1515 Green St"));
        onView(withId(R.id.province)).perform(replaceText("AB"));
        onView(withId(R.id.updateButton)).perform(click());
    }
}