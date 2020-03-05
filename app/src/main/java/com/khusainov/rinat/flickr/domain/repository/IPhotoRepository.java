package com.khusainov.rinat.flickr.domain.repository;

import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

import java.util.List;

import io.reactivex.Observable;

public interface IPhotoRepository {
    Observable<List<PhotoEntity>> getPhotoEntity(int page, int pageSize);
}
