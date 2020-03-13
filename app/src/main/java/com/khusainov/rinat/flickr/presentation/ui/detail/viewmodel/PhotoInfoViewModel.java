package com.khusainov.rinat.flickr.presentation.ui.detail.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.khusainov.rinat.flickr.domain.intercator.IPhotoInfoInteractor;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class PhotoInfoViewModel extends ViewModel {
    private MutableLiveData<PhotoInfoEntity> mPhotoInfo = new MutableLiveData<>();

    private IPhotoInfoInteractor mPhotoInfoInteractor;

    public PhotoInfoViewModel(IPhotoInfoInteractor photoInfoInteractor) {
        mPhotoInfoInteractor = photoInfoInteractor;
    }

    @SuppressLint("CheckResult")
    public void getPhotoInfo(String movieId) {
        mPhotoInfoInteractor.getPhotoInfoEntity(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photoInfoEntity -> mPhotoInfo.postValue(photoInfoEntity),
                        throwable -> Log.e(TAG, "accept: Error"));
    }

    public MutableLiveData<PhotoInfoEntity> getPhotoInfo() {
        return mPhotoInfo;
    }
}
