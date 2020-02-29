package com.khusainov.rinat.flickr.data.mapper;

import com.khusainov.rinat.flickr.data.model.Photo;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

import java.util.ArrayList;
import java.util.List;

public class PhotoMapper implements IMapper<List<Photo>, List<PhotoEntity>> {

    @Override
    public List<PhotoEntity> convert(List<Photo> photos) {
        List<PhotoEntity> entityList = new ArrayList<>();

        for (Photo photo : photos) {
            entityList.add(new PhotoEntity(
                    photo.getId(),
                    photo.getOwner(),
                    photo.getSecret(),
                    photo.getServer(),
                    photo.getFarm(),
                    photo.getTitle()
            ));
        }
        return entityList;
    }
}
