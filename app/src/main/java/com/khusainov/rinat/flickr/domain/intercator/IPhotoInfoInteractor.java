package com.khusainov.rinat.flickr.domain.intercator;

import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

import io.reactivex.Single;

public interface IPhotoInfoInteractor {
    Single<PhotoInfoEntity> getPhotoInfoEntity(String photoId);
}
