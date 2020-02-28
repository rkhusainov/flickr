package com.khusainov.rinat.flickr.presentation.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.data.model.PhotoResponse;
import com.khusainov.rinat.flickr.presentation.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends Fragment {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private RecyclerView mPhotoRecyclerView;
    private PhotoAdapter mPhotoAdapter = new PhotoAdapter();

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPhotos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mPhotoRecyclerView = view.findViewById(R.id.photos_recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mPhotoRecyclerView.setAdapter(mPhotoAdapter);
    }

    @SuppressLint("CheckResult")
    private void loadPhotos() {
        mCompositeDisposable.add(ApiUtils.getApi().getRecentPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhotoResponse>() {
                    @Override
                    public void accept(PhotoResponse response) throws Exception {
                        mPhotoAdapter.bindData(response.getPhotos().getPhoto());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }));
    }
}
