package com.khusainov.rinat.flickr.presentation;

import android.app.Application;

import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.di.app.DaggerAppComponent;

public class AppDelegate extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
