package com.khusainov.rinat.flickr.data.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.khusainov.rinat.flickr.presentation.AppDelegate;

public class PhotoDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PhotoDataSource> mSourceLiveData = new MutableLiveData<>();
    private PhotoDataSource mPhotoDataSource;

    public PhotoDataSourceFactory() {
        mPhotoDataSource = AppDelegate.getHomeComponent().getPhotoDataSource();
    }

    @Override
    public DataSource create() {
        mSourceLiveData.postValue(mPhotoDataSource);
        return mPhotoDataSource;
    }
}
