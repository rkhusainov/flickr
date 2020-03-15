package com.khusainov.rinat.flickr.detail;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.presentation.ui.detail.view.DetailFragment;
import com.khusainov.rinat.flickr.presentation.ui.home.view.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class DetailUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mActivityTestRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, DetailFragment.newInstance("49647027176"))
                .commitAllowingStateLoss();
    }

    @Test
    public void checkDetailFragmentIsDisplayed() {
//        onView(ViewMatchers.withId(R.id.photos_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(10,click()));
        onView(ViewMatchers.withId(R.id.detail_fragment)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPhotoViewIsVisible() {
        onView(ViewMatchers.withId(R.id.photo_view)).check(matches(isDisplayed()));
    }

    @Test
    public void checkUsernameIsVisible() {
        onView(ViewMatchers.withId(R.id.username_text_view)).check(matches(isDisplayed()));
//        onView(withText("mountainadventure999")).check(matches(isDisplayed()));
    }

    @Test
    public void checkTitleIsVisible() {
        onView(ViewMatchers.withId(R.id.title_text_view)).check(matches(isDisplayed()));
    }
}
