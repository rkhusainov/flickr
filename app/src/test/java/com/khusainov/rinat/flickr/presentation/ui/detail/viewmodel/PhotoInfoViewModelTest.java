package com.khusainov.rinat.flickr.presentation.ui.detail.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.khusainov.rinat.flickr.data.model.detail.Description;
import com.khusainov.rinat.flickr.data.model.detail.Owner;
import com.khusainov.rinat.flickr.data.model.detail.Title;
import com.khusainov.rinat.flickr.domain.intercator.IPhotoInfoInteractor;
import com.khusainov.rinat.flickr.domain.intercator.PhotoInfoInteractor;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PhotoInfoViewModelTest {

    private IPhotoInfoInteractor mPhotoInfoInteractor;
    private PhotoInfoEntity mPhotoInfoEntity;
    private PhotoInfoViewModel mInfoViewModel;

    // for MutableLiveData
    @Rule
    public InstantTaskExecutorRule mInstantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {

        // for solving error "getMainLooper in android.os.Looper not mocked"
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

        Owner owner = mock(Owner.class);
        Title title = mock(Title.class);
        Description description = mock(Description.class);

        mPhotoInfoEntity = new PhotoInfoEntity(
                "1",
                "12345",
                "3",
                3,
                "10.10.2020",
                1,
                "12345",
                "jpg",
                owner,
                title,
                description
        );

        mPhotoInfoInteractor = mock(PhotoInfoInteractor.class);
        mInfoViewModel = new PhotoInfoViewModel(mPhotoInfoInteractor);
    }

    @Test
    public void getPhotoInfo() {
        MutableLiveData<PhotoInfoEntity> observer = mInfoViewModel.getPhotoInfo();
        observer.setValue(mPhotoInfoEntity);
        assertThat(mInfoViewModel.getPhotoInfo().getValue(),is(mPhotoInfoEntity));
        assertThat(mInfoViewModel.getPhotoInfo().getValue().getSecret(), is(mPhotoInfoEntity.getSecret()));
    }
}