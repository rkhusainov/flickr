package com.khusainov.rinat.flickr.presentation.di.home;

import com.khusainov.rinat.flickr.data.datasource.PhotoDataSource;
import com.khusainov.rinat.flickr.data.datasource.PhotoDataSourceFactory;
import com.khusainov.rinat.flickr.data.mapper.PhotoMapper;
import com.khusainov.rinat.flickr.data.repository.PhotoRepository;
import com.khusainov.rinat.flickr.domain.repository.IPhotoRepository;
import com.khusainov.rinat.flickr.presentation.di.scope.PerScreen;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoFactory;
import com.khusainov.rinat.flickr.presentation.ui.home.viewmodel.PhotoViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    @PerScreen
    PhotoMapper providePhotoMapper() {
        return new PhotoMapper();
    }

    @Provides
    @PerScreen
    PhotoDataSource providePhotoDataSource() {
        return new PhotoDataSource();
    }

    @Provides
    @PerScreen
    IPhotoRepository providePhotoRepository(PhotoMapper mapper) {
        return new PhotoRepository(mapper);
    }

    @Provides
    @PerScreen
    PhotoViewModel providePhotoViewModel() {
        return new PhotoViewModel();
    }

    @Provides
    @PerScreen
    PhotoDataSourceFactory providePhotoDataSourceFactory() {
        return new PhotoDataSourceFactory();
    }

    @Provides
    @PerScreen
    PhotoFactory providePhotoFactory() {
        return new PhotoFactory();
    }
}
