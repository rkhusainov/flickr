package com.khusainov.rinat.flickr.presentation;

import android.app.Application;

import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.di.app.DaggerAppComponent;
import com.khusainov.rinat.flickr.presentation.di.detail.DaggerDetailComponent;
import com.khusainov.rinat.flickr.presentation.di.detail.DetailComponent;
import com.khusainov.rinat.flickr.presentation.di.home.DaggerHomeComponent;
import com.khusainov.rinat.flickr.presentation.di.home.HomeComponent;

public class AppDelegate extends Application {
    private static AppComponent sAppComponent;
    private static HomeComponent sHomeComponent;
    private static DetailComponent sDetailComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .build();
    }

    public static HomeComponent getHomeComponent() {
        if (sHomeComponent == null) {
            sHomeComponent = DaggerHomeComponent.builder()
                    .appComponent(getAppComponent())
                    .build();
        }
        return sHomeComponent;
    }

    public static DetailComponent getDetailComponent() {
        if (sDetailComponent == null) {
            sDetailComponent = DaggerDetailComponent.builder()
                    .appComponent(getAppComponent())
                    .build();
        }
        return sDetailComponent;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static void destroyHomeComponent() {
        sHomeComponent = null;
    }

    public static void destroyDetailComponent() {
        sDetailComponent = null;
    }
}
