package com.khusainov.rinat.flickr.presentation.di.home;

import com.khusainov.rinat.flickr.presentation.di.scope.PerFeature;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @Provides
    @PerFeature
    PhotoFactory providePhotoFactory() {
        return new PhotoFactory();
    }
}
