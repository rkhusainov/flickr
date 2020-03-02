package com.khusainov.rinat.flickr.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khusainov.rinat.flickr.presentation.viewmodel.PhotoViewModel;

public class PhotoFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PhotoViewModel();
    }
}
