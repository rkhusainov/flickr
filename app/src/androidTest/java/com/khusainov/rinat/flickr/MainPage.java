package com.khusainov.rinat.flickr;

import androidx.test.espresso.ViewInteraction;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainPage {
    private ViewInteraction mRecyclerView = onView(withId(R.id.photos_recycler_view));

    public ViewInteraction getRecyclerView() {
        return mRecyclerView;
    }
}
