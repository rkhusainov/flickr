package com.khusainov.rinat.flickr.presentation.di.app;

import com.khusainov.rinat.flickr.presentation.AppDelegate;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final AppDelegate mAppDelegate;

    public AppModule(AppDelegate appDelegate) {
        mAppDelegate = appDelegate;
    }

    @Provides
    @Singleton
    AppDelegate provideApp() {
        return mAppDelegate;
    }
}
