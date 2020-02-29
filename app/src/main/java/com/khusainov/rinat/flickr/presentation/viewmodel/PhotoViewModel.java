package com.khusainov.rinat.flickr.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.khusainov.rinat.flickr.domain.interactor.IDataInteractor;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PhotoViewModel extends ViewModel {

    private CompositeDisposable mCompositeDisposable;
    private IDataInteractor mDataInteractor;

    private MutableLiveData<List<PhotoEntity>> mPhotos = new MutableLiveData<>();

    public PhotoViewModel(IDataInteractor interactor) {
        mDataInteractor = interactor;
        mCompositeDisposable = new CompositeDisposable();
        loadPhotos();
    }

    private void loadPhotos() {
        mCompositeDisposable.add(mDataInteractor.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PhotoEntity>>() {
                    @Override
                    public void accept(List<PhotoEntity> photos) throws Exception {
                        mPhotos.postValue(photos);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // TODO: 29.02.20 Error
                    }
                }));
    }

    public MutableLiveData<List<PhotoEntity>> getPhotos() {
        return mPhotos;
    }
}
