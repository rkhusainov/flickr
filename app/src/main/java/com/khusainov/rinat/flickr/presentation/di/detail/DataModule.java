package com.khusainov.rinat.flickr.presentation.di.detail;

import com.khusainov.rinat.flickr.data.mapper.PhotoInfoMapper;
import com.khusainov.rinat.flickr.data.repository.PhotoInfoRepository;
import com.khusainov.rinat.flickr.domain.intercator.IPhotoInfoInteractor;
import com.khusainov.rinat.flickr.domain.intercator.PhotoInfoInteractor;
import com.khusainov.rinat.flickr.presentation.di.scope.PerScreen;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoInfoFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @PerScreen
    PhotoInfoFactory providePhotoInfoFactory() {
        return new PhotoInfoFactory();
    }

    @Provides
    @PerScreen
    IPhotoInfoInteractor providePhotoInfoInteractor() {
        return new PhotoInfoInteractor(new PhotoInfoRepository(new PhotoInfoMapper()));
    }
}
