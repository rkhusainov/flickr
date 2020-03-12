package com.khusainov.rinat.flickr.presentation;

import android.app.Application;

import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.di.app.DaggerAppComponent;
import com.khusainov.rinat.flickr.presentation.di.home.DaggerGalleryComponent;
import com.khusainov.rinat.flickr.presentation.di.home.GalleryComponent;

public class AppDelegate extends Application {
    private static AppComponent sAppComponent;
    private static GalleryComponent sGalleryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .build();
    }

    public static GalleryComponent getGalleryComponent() {
        if (sGalleryComponent == null) {
            sGalleryComponent = DaggerGalleryComponent.builder()
                    .appComponent(getAppComponent())
                    .build();
        }
        return sGalleryComponent;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static void destroyGalleryComponent() {
        sGalleryComponent = null;
    }
}
