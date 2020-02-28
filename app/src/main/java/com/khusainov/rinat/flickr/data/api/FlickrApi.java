package com.khusainov.rinat.flickr.data.api;

import com.khusainov.rinat.flickr.data.model.PhotoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface FlickrApi {
    @GET("services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    Single<PhotoResponse> getRecentPhotos();
}
