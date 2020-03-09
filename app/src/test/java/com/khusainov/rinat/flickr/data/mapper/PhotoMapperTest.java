package com.khusainov.rinat.flickr.data.mapper;

import com.khusainov.rinat.flickr.data.model.Photo;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhotoMapperTest {

    private PhotoMapper mPhotoMapper;
    private Photo mPhoto;
    private PhotoEntity mPhotoEntity;
    private List<Photo> mPhotoList=new ArrayList<>();
    private List<PhotoEntity> mPhotoEntityList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mPhotoMapper = new PhotoMapper();

        mPhoto = new Photo(
                "1",
                "Bill Gates",
                "123456",
                "123123",
                4,
                "Windows"
        );

        mPhotoEntity = new PhotoEntity(
                "1",
                "Bill Gates",
                "123456",
                "123123",
                4,
                "Windows"
        );

        mPhotoList.add(mPhoto);
        mPhotoEntityList.add(mPhotoEntity);
    }

    @Test
    public void convert() {
        List<PhotoEntity> expected = mPhotoMapper.convert(mPhotoList);
        assertThat(mPhotoEntityList, is(expected));
    }
}