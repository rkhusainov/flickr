package com.khusainov.rinat.flickr.domain.intercator;

import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;
import com.khusainov.rinat.flickr.domain.repository.IPhotoInfoRepository;

import io.reactivex.Single;

public class PhotoInfoInteractor implements IPhotoInfoInteractor {

    IPhotoInfoRepository mPhotoInfoRepository;

    public PhotoInfoInteractor(IPhotoInfoRepository photoInfoRepository) {
        mPhotoInfoRepository = photoInfoRepository;
    }

    @Override
    public Single<PhotoInfoEntity> getPhotoInfoEntity(String photoId) {
        return mPhotoInfoRepository.getPhotoInfoEntity(photoId);
    }
}
