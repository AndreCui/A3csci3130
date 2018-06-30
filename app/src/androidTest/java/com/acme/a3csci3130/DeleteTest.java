package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;



import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class DeleteTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void Delete() throws InterruptedException{
        Thread.sleep(2000);
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());


    }
}