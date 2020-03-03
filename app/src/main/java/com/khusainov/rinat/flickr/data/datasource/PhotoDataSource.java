package com.khusainov.rinat.flickr.data.datasource;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.data.model.PhotoResponse;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.presentation.AppDelegate;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class PhotoDataSource extends PageKeyedDataSource<Integer, PhotoEntity> {

//    @Inject
    FlickrApi mApi;

    private IMapper mMapper;

    public PhotoDataSource(IMapper mapper) {
        mMapper = mapper;
        mApi = AppDelegate.getAppComponent().getApi();
//        AppDelegate.getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PhotoEntity> callback) {
        mApi.getRecentPhotos(1, params.requestedLoadSize)
                .map(new Function<PhotoResponse, List<PhotoEntity>>() {
                    @Override
                    public List<PhotoEntity> apply(PhotoResponse response) throws Exception {
                        return (List<PhotoEntity>) mMapper.convert(response.getPhotos().getPhoto());
                    }
                }).subscribe(new Consumer<List<PhotoEntity>>() {
            @Override
            public void accept(List<PhotoEntity> photoEntities) throws Exception {
                callback.onResult(photoEntities, null, 2);
            }
        });
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PhotoEntity> callback) {
        mApi.getRecentPhotos(params.key, params.requestedLoadSize)
                .map(new Function<PhotoResponse, List<PhotoEntity>>() {
                    @Override
                    public List<PhotoEntity> apply(PhotoResponse response) throws Exception {
                        return (List<PhotoEntity>) mMapper.convert(response.getPhotos().getPhoto());
                    }
                }).subscribe(new Consumer<List<PhotoEntity>>() {
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
