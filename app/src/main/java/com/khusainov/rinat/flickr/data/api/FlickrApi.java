package com.khusainov.rinat.flickr.data.api;

import com.khusainov.rinat.flickr.data.model.PhotoResponse;
import com.khusainov.rinat.flickr.data.model.detail.PhotoInfoResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrApi {
    @GET("services/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    Observable<PhotoResponse> getRecentPhotos(
            @Query("page") int page,
            @Query("per_page") int pageSize
    );

    @GET("services/rest/?method=flickr.photos.getInfo&format=json&nojsoncallback=1")
    Single<PhotoInfoResponse> getPhotoInfoResponse(
            @Query("photo_id") String photoId
    );
}
