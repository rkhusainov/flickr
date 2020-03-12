package com.khusainov.rinat.flickr.data.model.detail;

import com.google.gson.annotations.SerializedName;

public class PhotoInfoResponse {
    @SerializedName("photo")
    private PhotoInfo mPhotoInfo;

    public PhotoInfo getPhotoInfo() {
        return mPhotoInfo;
    }

    public void setPhoto(PhotoInfo photoInfo) {
        mPhotoInfo = photoInfo;
    }
}
