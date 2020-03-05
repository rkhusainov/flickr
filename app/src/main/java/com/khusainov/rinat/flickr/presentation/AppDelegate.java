package com.khusainov.rinat.flickr.presentation;

import android.app.Application;

import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.di.app.DaggerAppComponent;
import com.khusainov.rinat.flickr.presentation.di.gallery.DaggerGalleryComponent;
import com.khusainov.rinat.flickr.presentation.di.gallery.GalleryComponent;

public class AppDelegate extends Application {
    private static AppComponent sAppComponent;
    private static GalleryComponent sGalleryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .build();

        sGalleryComponent = DaggerGalleryComponent.builder()
                .appComponent(getAppComponent())
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static GalleryComponent getGalleryComponent() {
        return sGalleryComponent;
    }
}
