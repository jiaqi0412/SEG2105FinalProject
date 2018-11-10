package com.example.lijia.finalproject;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



import org.junit.Rule;
import org.junit.Test;
import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class adminProfileTest {
    @Rule
    public ActivityTestRule<adminProfile> mActivityTestRule = new ActivityTestRule<>(adminProfile.class);


    @Test
    public void emailIsInvalid() {
//        onView(withId(R.id.signUpButton)).perform(click());
//        onView(withId(R.id.adminSignInButton)).perform(click());
//
//        onView(withId(R.id.signInName)).perform(typeText("admin"), closeSoftKeyboard());
//        onView(withId(R.id.signInPassword)).perform(typeText("admin"), closeSoftKeyboard());
//        onView(withId(R.id.signInButton)).perform(click());
//        onView(withId(R.id.goToProfile)).perform(click());

        onView(withId(R.id.serviceName)).perform(typeText("wash1"), closeSoftKeyboard());
        onView(withId(R.id.serviceHourlyRate)).perform(typeText("65"), closeSoftKeyboard());

        onView(withId(R.id.adminAddService)).perform(click());
//        onView(withText("Invalid Email")).check(matches(isDisplayed()));
//        onView(withText("Invalid username")).check(matches(isDisplayed()));
//        onView(withText("Invalid lastname")).check(matches(isDisplayed()));

    }
}
