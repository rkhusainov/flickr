package com.khusainov.rinat.flickr.presentation.ui.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khusainov.rinat.flickr.domain.intercator.IPhotoInfoInteractor;
import com.khusainov.rinat.flickr.presentation.AppDelegate;
import com.khusainov.rinat.flickr.presentation.ui.detail.viewmodel.PhotoInfoViewModel;

public class PhotoInfoFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IPhotoInfoInteractor photoInfoInteractor = AppDelegate.getDetailComponent().getPhotoInfoInteractor();
        return (T) new PhotoInfoViewModel(photoInfoInteractor);
    }
}
