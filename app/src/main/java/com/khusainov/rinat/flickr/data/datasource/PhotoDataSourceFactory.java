package com.khusainov.rinat.flickr.data.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.khusainov.rinat.flickr.data.mapper.PhotoMapper;

public class PhotoDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PhotoDataSource> mSourceLiveData = new MutableLiveData<>();
    private PhotoDataSource mPhotoDataSource;

    @Override
    public DataSource create() {
        mPhotoDataSource = new PhotoDataSource(new PhotoMapper());
        mSourceLiveData.postValue(mPhotoDataSource);
        return mPhotoDataSource;
    }
}
