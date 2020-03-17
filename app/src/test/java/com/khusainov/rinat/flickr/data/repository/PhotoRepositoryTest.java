package com.khusainov.rinat.flickr.data.repository;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.data.model.Photo;
import com.khusainov.rinat.flickr.data.model.PhotoResponse;
import com.khusainov.rinat.flickr.data.model.Photos;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import io.reactivex.Observable;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PhotoRepositoryTest {

    public static final int PAGE = 1;
    public static final int PAGE_SIZE = 20;

    private PhotoResponse mPhotoResponse;
    private Photos mPhotos;
    private Photo mPhoto;
    private FlickrApi mApi;

    @Before
    public void setUp() {

        mPhoto = new Photo(
                "1",
                "Bill Gates",
                "123456",
                "123123",
                4,
                "Windows"
        );

        mPhotos = new Photos(
                1,
                10,
                10,
                1000,
                Arrays.asList(mPhoto, mPhoto)
        );

        mPhotoResponse = new PhotoResponse(mPhotos);
        mApi = mock(FlickrApi.class);
    }

    @Test
    public void getPhotoEntity_IntInt() {
        when(mApi.getRecentPhotos(PAGE, PAGE_SIZE)).thenReturn(Observable.fromCallable(() -> mPhotoResponse));
        PhotoResponse photoResponse = mApi.getRecentPhotos(PAGE, PAGE_SIZE).blockingFirst();

        assertEquals("Windows", photoResponse.getPhotos().getPhoto().get(0).getTitle());
        assertThat(photoResponse.getPhotos().getPhoto().get(0).getOwner(), equalTo("Bill Gates"));
        assertNotNull(photoResponse);
        verify(mApi, times(1)).getRecentPhotos(PAGE, PAGE_SIZE);
    }
}