package com.khusainov.rinat.flickr.domain.intercator;

import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;
import com.khusainov.rinat.flickr.domain.repository.IPhotoInfoRepository;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PhotoInfoInteractorTest {

    public static final String PHOTO_ID = "49647027176";
    private IPhotoInfoInteractor mInfoInteractor;
    private IPhotoInfoRepository mInfoRepository;

    @Before
    public void setUp() throws Exception {
        mInfoRepository = mock(IPhotoInfoRepository.class);
        mInfoInteractor = new PhotoInfoInteractor(mInfoRepository);
    }

    @Test
    public void getPhotoInfoEntity() {
        PhotoInfoEntity photoInfoEntity = mock(PhotoInfoEntity.class);
        when(mInfoRepository.getPhotoInfoEntity(PHOTO_ID)).thenReturn(Single.fromCallable(() -> photoInfoEntity));

        // act
        TestObserver<PhotoInfoEntity> observer = mInfoInteractor.getPhotoInfoEntity(PHOTO_ID).test();

        // assert
        observer.assertValue(photoInfoEntity);
        observer.dispose();

        // verify
        verify(mInfoRepository).getPhotoInfoEntity(PHOTO_ID);
        verifyZeroInteractions(mInfoRepository);
    }
}