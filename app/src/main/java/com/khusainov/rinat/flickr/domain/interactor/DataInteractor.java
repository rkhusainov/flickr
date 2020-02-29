package com.khusainov.rinat.flickr.domain.interactor;

import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.domain.repository.IDataRepository;

import java.util.List;

import io.reactivex.Observable;

public class DataInteractor implements IDataInteractor {

    private IDataRepository mDataRepository;

    public DataInteractor(IDataRepository dataRepository) {
        mDataRepository = dataRepository;
    }

    @Override
    public Observable<List<PhotoEntity>> getPhotos() {
        return mDataRepository.getPhotos();
    }
}
