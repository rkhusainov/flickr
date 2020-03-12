package com.khusainov.rinat.flickr.presentation.ui.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khusainov.rinat.flickr.presentation.AppDelegate;
import com.khusainov.rinat.flickr.presentation.ui.home.viewmodel.PhotoViewModel;

public class PhotoFactory extends ViewModelProvider.NewInstanceFactory {

    private PhotoViewModel mPhotoViewModel = AppDelegate.getGalleryComponent().getPhotoViewModel();

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PhotoViewModel.class)) {
            return (T) mPhotoViewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
