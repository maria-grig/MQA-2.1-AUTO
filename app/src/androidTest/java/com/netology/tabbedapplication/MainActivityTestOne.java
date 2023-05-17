package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestOne {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTestOne() {
        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.constraintlayout.widget.R.id.action_bar_root),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));


        ViewInteraction textView = onView(
                allOf(withText("TAB 1"),
                        withParent(allOf(withContentDescription("Tab 1"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView.check(matches(withText("TAB 1")));

        ViewInteraction textView2 = onView(
                allOf(withText("TAB 2"),
                        withParent(allOf(withContentDescription("Tab 2"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView2.check(matches(withText("TAB 2")));
    }
}
