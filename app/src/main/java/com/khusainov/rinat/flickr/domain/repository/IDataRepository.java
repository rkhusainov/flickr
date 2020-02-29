package com.khusainov.rinat.flickr.domain.repository;

import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

import java.util.List;

import io.reactivex.Observable;

public interface IDataRepository {
    Observable<List<PhotoEntity>> getPhotos();
}
