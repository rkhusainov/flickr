package com.khusainov.rinat.flickr.home;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import com.khusainov.rinat.flickr.R;

import static androidx.test.espresso.Espresso.onView;

public class HomePage {
    private ViewInteraction mRecyclerView = onView(ViewMatchers.withId(R.id.photos_recycler_view));

    public ViewInteraction getRecyclerView() {
        return mRecyclerView;
    }
}
