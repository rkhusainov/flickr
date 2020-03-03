package com.khusainov.rinat.flickr.presentation.di.app;

import com.khusainov.rinat.flickr.data.api.FlickrApi;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
//    void inject(PhotoDataSource dataSource);
    FlickrApi getApi();
}
