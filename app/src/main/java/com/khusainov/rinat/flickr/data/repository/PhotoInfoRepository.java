package com.khusainov.rinat.flickr.data.repository;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.data.model.detail.PhotoInfoResponse;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;
import com.khusainov.rinat.flickr.domain.repository.IPhotoInfoRepository;
import com.khusainov.rinat.flickr.presentation.AppDelegate;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class PhotoInfoRepository implements IPhotoInfoRepository {

    private FlickrApi mApi;
    private IMapper mMapper;

    public PhotoInfoRepository(IMapper mapper) {
        mMapper = mapper;
        mApi = AppDelegate.getDetailComponent().getApi();
    }

    @Override
    public Single<PhotoInfoEntity> getPhotoInfoEntity(String photoId) {
        return mApi.getPhotoInfoResponse(photoId)
                .map(new Function<PhotoInfoResponse, PhotoInfoEntity>() {
                    @Override
                    public PhotoInfoEntity apply(PhotoInfoResponse photoInfoResponse) throws Exception {
                        return (PhotoInfoEntity) mMapper.convert(photoInfoResponse.getPhotoInfo());
                    }
                });
    }
}
