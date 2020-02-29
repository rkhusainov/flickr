package com.khusainov.rinat.flickr.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.khusainov.rinat.flickr.data.mapper.PhotoMapper;
import com.khusainov.rinat.flickr.data.repository.DataRepository;
import com.khusainov.rinat.flickr.domain.interactor.DataInteractor;
import com.khusainov.rinat.flickr.domain.interactor.IDataInteractor;
import com.khusainov.rinat.flickr.domain.repository.IDataRepository;
import com.khusainov.rinat.flickr.presentation.viewmodel.PhotoViewModel;

public class PhotoFactory extends ViewModelProvider.NewInstanceFactory {

    @SuppressWarnings("unchecked cast")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IDataRepository dataRepository = new DataRepository(new PhotoMapper());
        IDataInteractor dataInteractor = new DataInteractor(dataRepository);
        return (T) new PhotoViewModel(
                dataInteractor
        );
    }
}
