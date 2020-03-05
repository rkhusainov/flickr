package com.khusainov.rinat.flickr.presentation.di.gallery;

import com.khusainov.rinat.flickr.data.datasource.PhotoDataSource;
import com.khusainov.rinat.flickr.data.datasource.PhotoDataSourceFactory;
import com.khusainov.rinat.flickr.data.mapper.PhotoMapper;
import com.khusainov.rinat.flickr.data.repository.PhotoRepository;
import com.khusainov.rinat.flickr.domain.repository.IPhotoRepository;
import com.khusainov.rinat.flickr.presentation.viewmodel.PhotoViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    @PerFeature
    PhotoMapper providePhotoMapper() {
        return new PhotoMapper();
    }

    @Provides
    @PerFeature
    PhotoDataSource providePhotoDataSource() {
        return new PhotoDataSource();
    }

    @Provides
    @PerFeature
    IPhotoRepository providePhotoRepository(PhotoMapper mapper) {
        return new PhotoRepository(mapper);
    }

    @Provides
    @PerFeature
    PhotoViewModel providePhotoViewModel() {
        return new PhotoViewModel();
    }

    @Provides
    @PerFeature
    PhotoDataSourceFactory providePhotoDataSourceFactory() {
        return new PhotoDataSourceFactory();
    }


}
