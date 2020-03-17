package com.khusainov.rinat.flickr.data.mapper;

import com.khusainov.rinat.flickr.data.model.detail.Description;
import com.khusainov.rinat.flickr.data.model.detail.Owner;
import com.khusainov.rinat.flickr.data.model.detail.PhotoInfo;
import com.khusainov.rinat.flickr.data.model.detail.Title;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PhotoInfoMapperTest {

    private PhotoInfo mPhotoInfo;
    private PhotoInfoEntity mPhotoInfoEntity;
    private IMapper<PhotoInfo, PhotoInfoEntity> mMapper;

    @Before
    public void setUp() throws Exception {
        mMapper = new PhotoInfoMapper();
        Owner owner = mock(Owner.class);
        Title title = mock(Title.class);
        Description description = mock(Description.class);

        mPhotoInfo = new PhotoInfo(
                "1",
                "12345",
                "3",
                3,
                "10.10.2020",
                1,
                "12345",
                "jpg",
                owner,
                title,
                description
        );

        mPhotoInfoEntity = new PhotoInfoEntity(
                "1",
                "12345",
                "3",
                3,
                "10.10.2020",
                1,
                "12345",
                "jpg",
                owner,
                title,
                description
        );
    }

    @Test
    public void convert() {
        PhotoInfoEntity expected = mMapper.convert(mPhotoInfo);
        assertThat(mPhotoInfoEntity, is(expected));
    }
}