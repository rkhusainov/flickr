package com.khusainov.rinat.flickr.presentation.di.gallery;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.data.datasource.PhotoDataSource;
import com.khusainov.rinat.flickr.data.datasource.PhotoDataSourceFactory;
import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.factory.PhotoFactory;
import com.khusainov.rinat.flickr.presentation.view.PhotoAdapter;
import com.khusainov.rinat.flickr.presentation.viewmodel.PhotoViewModel;

import dagger.Component;

@PerFeature
@Component(dependencies = {AppComponent.class}, modules = {DataModule.class, FragmentModule.class})
public interface GalleryComponent {
    FlickrApi getApi();

    PhotoDataSource getPhotoDataSource();

    PhotoViewModel getPhotoViewModel();

    PhotoAdapter getPhotoAdapter();

    PhotoFactory getPhotoFactory();

    void inject(PhotoViewModel photoViewModel);

    void inject(PhotoDataSourceFactory photoDataSourceFactory);
}
