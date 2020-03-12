package com.khusainov.rinat.flickr.presentation.ui.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.khusainov.rinat.flickr.data.datasource.PhotoDataSourceFactory;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.presentation.AppDelegate;

import javax.inject.Inject;

public class PhotoViewModel extends ViewModel {

    private LiveData<PagedList<PhotoEntity>> mPhotos;
    @Inject
    PhotoDataSourceFactory mPhotoDataSourceFactory;

    public PhotoViewModel() {
        AppDelegate.getGalleryComponent().inject(this);
        DataSourceFactorInit();
    }

    private void DataSourceFactorInit() {

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

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDelegate.destroyGalleryComponent();
    }
}
