package com.circleci.mnabilelsaye.androidci;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest
{

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class , false,false);

    @Before
    public void setUp() throws Exception {
        loginActivityActivityTestRule.launchActivity(null);
    }

    @Test
    public void userlogin()
    {
        String email = "moatazeldebsy@gmail.com";
        String password = "123456" ;

        onView(withId(R.id.email))
                .check(matches(isDisplayed()))
                .perform(clearText())
                .perform(typeText(email));
        onView(withId(R.id.password))
                .check(matches(isDisplayed()))
                .perform(clearText())
                .perform(typeText(password),closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button))
                .check(matches(isDisplayed()))
                .perform(click());

    }

}