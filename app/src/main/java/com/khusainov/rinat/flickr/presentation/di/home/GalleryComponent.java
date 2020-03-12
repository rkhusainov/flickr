package com.khusainov.rinat.flickr.presentation.di.home;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.data.datasource.PhotoDataSource;
import com.khusainov.rinat.flickr.data.datasource.PhotoDataSourceFactory;
import com.khusainov.rinat.flickr.domain.repository.IPhotoRepository;
import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.di.scope.PerFeature;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoFactory;
import com.khusainov.rinat.flickr.presentation.ui.home.viewmodel.PhotoViewModel;

import dagger.Component;

@PerFeature
@Component(dependencies = {AppComponent.class}, modules = {DataModule.class, FragmentModule.class})
public interface GalleryComponent {
    FlickrApi getApi();

    PhotoDataSource getPhotoDataSource();

    IPhotoRepository getPhotoRepository();

    PhotoViewModel getPhotoViewModel();

    PhotoFactory getPhotoFactory();

    void inject(PhotoViewModel photoViewModel);

    void inject(PhotoDataSourceFactory photoDataSourceFactory);
}
