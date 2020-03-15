package com.khusainov.rinat.flickr.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.presentation.ui.home.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class HomeUITest {

    private HomePage page = new HomePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkHomeFragmentIsDisplayed() {
        onView(ViewMatchers.withId(R.id.home_fragment)).check(matches(isDisplayed()));
    }

    @Test
    public void checkRecyclerView() {
        page.getRecyclerView().check(matches(isDisplayed()));
        page.getRecyclerView().perform(RecyclerViewActions.scrollToPosition(40));
    }

}
