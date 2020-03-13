package com.khusainov.rinat.flickr.presentation.di.detail;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.domain.intercator.IPhotoInfoInteractor;
import com.khusainov.rinat.flickr.presentation.di.app.AppComponent;
import com.khusainov.rinat.flickr.presentation.di.scope.PerScreen;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoInfoFactory;

import dagger.Component;

@PerScreen
@Component(dependencies = {AppComponent.class}, modules = {DataModule.class})
public interface DetailComponent {
    FlickrApi getApi();

    PhotoInfoFactory getPhotoInfoFactory();

    IPhotoInfoInteractor getPhotoInfoInteractor();
}
