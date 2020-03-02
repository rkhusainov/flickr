package com.khusainov.rinat.flickr.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.khusainov.rinat.flickr.data.datasource.PhotoDataSourceFactory;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

public class PhotoViewModel extends ViewModel {

    private LiveData<PagedList<PhotoEntity>> mPhotos;

    private PhotoDataSourceFactory mPhotoDataSourceFactory;

    public PhotoViewModel() {
        DataSourceFactorInit();
    }

    private void DataSourceFactorInit() {
        mPhotoDataSourceFactory = new PhotoDataSourceFactory();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20)
                        .build();

        mPhotos = new LivePagedListBuilder(mPhotoDataSourceFactory, pagedListConfig).build();
    }

    public LiveData<PagedList<PhotoEntity>> getPhotos() {
        return mPhotos;
    }
}
