package com.khusainov.rinat.flickr.data.repository;

import com.khusainov.rinat.flickr.data.model.detail.Description;
import com.khusainov.rinat.flickr.data.model.detail.Owner;
import com.khusainov.rinat.flickr.data.model.detail.Title;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhotoInfoRepositoryTest {

    private PhotoInfoRepository mPhotoInfoRepository;
    private PhotoInfoEntity mPhotoInfoEntity;

    @Before
    public void setUp() throws Exception {

        mPhotoInfoRepository = mock(PhotoInfoRepository.class);
        Owner owner = mock(Owner.class);
        Title title = mock(Title.class);
        Description description = mock(Description.class);

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
    public void getPhotoInfoEntity() {
        when(mPhotoInfoRepository.getPhotoInfoEntity("49647027176")).thenReturn(Single.fromCallable(() -> mPhotoInfoEntity));
        TestObserver<PhotoInfoEntity> observer = mPhotoInfoRepository.getPhotoInfoEntity("49647027176").test();
        observer.assertValue(mPhotoInfoEntity);
        observer.dispose();
    }
}