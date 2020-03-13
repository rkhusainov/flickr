package com.khusainov.rinat.flickr.data.datasource;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.domain.repository.IPhotoRepository;
import com.khusainov.rinat.flickr.presentation.AppDelegate;

import java.util.List;

import io.reactivex.functions.Consumer;

public class PhotoDataSource extends PageKeyedDataSource<Integer, PhotoEntity> {

    private IPhotoRepository mPhotoRepository;

    public PhotoDataSource() {
        mPhotoRepository = AppDelegate.getHomeComponent().getPhotoRepository();
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PhotoEntity> callback) {

        mPhotoRepository.getPhotoEntity(1, params.requestedLoadSize)
                .subscribe(new Consumer<List<PhotoEntity>>() {
                    @Override
                    public void accept(List<PhotoEntity> photoEntities) throws Exception {
                        callback.onResult(photoEntities, null, 2);
                    }
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoEntity> callback) {

        mPhotoRepository.getPhotoEntity(params.key, params.requestedLoadSize)
                .subscribe(new Consumer<List<PhotoEntity>>() {
                    @Override
                    public void accept(List<PhotoEntity> photoEntities) throws Exception {
                        callback.onResult(photoEntities, params.key + 1);
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, PhotoEntity> callback) {

    }
}
