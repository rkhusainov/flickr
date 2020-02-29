package com.khusainov.rinat.flickr.domain.interactor;

import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

import java.util.List;

import io.reactivex.Observable;

public interface IDataInteractor {
    Observable<List<PhotoEntity>> getPhotos();
}
