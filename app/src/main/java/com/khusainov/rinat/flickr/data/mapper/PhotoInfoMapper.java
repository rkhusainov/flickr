package com.khusainov.rinat.flickr.data.mapper;

import com.khusainov.rinat.flickr.data.model.detail.PhotoInfo;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

public class PhotoInfoMapper implements IMapper<PhotoInfo, PhotoInfoEntity> {

    @Override
    public PhotoInfoEntity convert(PhotoInfo photoInfo) {
        return new PhotoInfoEntity(
                photoInfo.getId(),
                photoInfo.getSecret(),
                photoInfo.getServer(),
                photoInfo.getFarm(),
                photoInfo.getDateuploaded(),
                photoInfo.getIsfavorite(),
                photoInfo.getOriginalsecret(),
                photoInfo.getOriginalformat(),
                photoInfo.getOwner(),
                photoInfo.getTitle(),
                photoInfo.getDescription()
        );
    }
}
