package com.khusainov.rinat.flickr.presentation.ui.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khusainov.rinat.flickr.data.mapper.PhotoInfoMapper;
import com.khusainov.rinat.flickr.data.repository.PhotoInfoRepository;
import com.khusainov.rinat.flickr.domain.intercator.IPhotoInfoInteractor;
import com.khusainov.rinat.flickr.domain.intercator.PhotoInfoInteractor;
import com.khusainov.rinat.flickr.domain.repository.IPhotoInfoRepository;
import com.khusainov.rinat.flickr.presentation.ui.detail.viewmodel.PhotoInfoViewModel;

public class PhotoInfoFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IPhotoInfoRepository repository = new PhotoInfoRepository(new PhotoInfoMapper());
        IPhotoInfoInteractor interactor = new PhotoInfoInteractor(repository);
        return (T) new PhotoInfoViewModel(interactor);
    }
}
