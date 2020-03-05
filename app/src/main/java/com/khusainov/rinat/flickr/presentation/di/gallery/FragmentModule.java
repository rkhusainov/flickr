package com.khusainov.rinat.flickr.presentation.di.gallery;

import com.khusainov.rinat.flickr.presentation.factory.PhotoFactory;
import com.khusainov.rinat.flickr.presentation.view.PhotoAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @Provides
    @PerFeature
    PhotoAdapter providePhotoAdapter() {
        return new PhotoAdapter();
    }

    @Provides
    @PerFeature
    PhotoFactory providePhotoFactory() {
        return new PhotoFactory();
    }
}
