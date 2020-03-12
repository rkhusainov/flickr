package com.khusainov.rinat.flickr.domain.repository;

import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

import io.reactivex.Single;

public interface IPhotoInfoRepository {
    Single<PhotoInfoEntity> getPhotoInfoEntity(String photoId);
}
