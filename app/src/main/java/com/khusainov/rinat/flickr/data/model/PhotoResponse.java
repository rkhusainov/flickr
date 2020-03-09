package com.khusainov.rinat.flickr.data.model;

import com.google.gson.annotations.SerializedName;

public class PhotoResponse {
    @SerializedName("photos")
    private Photos mPhotos;

    public PhotoResponse(Photos photos) {
        mPhotos = photos;
    }

    public Photos getPhotos() {
        return mPhotos;
    }

    public void setPhotos(Photos photos) {
        mPhotos = photos;
    }
}
