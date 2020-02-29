package com.khusainov.rinat.flickr.data.api;

import com.khusainov.rinat.flickr.data.model.PhotoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrApi {
    @GET("services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    Observable<PhotoResponse> getRecentPhotos(
            @Query("page") int page
    );
}
