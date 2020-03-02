package com.khusainov.rinat.flickr.presentation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.presentation.factory.PhotoFactory;
import com.khusainov.rinat.flickr.presentation.viewmodel.PhotoViewModel;

public class HomeFragment extends Fragment {

    private PhotoViewModel mPhotoViewModel;
    private RecyclerView mPhotoRecyclerView;
    private PhotoAdapter mPhotoAdapter = new PhotoAdapter();

    public static HomeFragment newInstance() {
        return new HomeFragment();
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
        setupMvvm();
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mPhotoRecyclerView.setAdapter(mPhotoAdapter);
    }

    private void setupMvvm() {
        PhotoFactory factory = new PhotoFactory();
        mPhotoViewModel = new ViewModelProvider(this, factory).get(PhotoViewModel.class);
        mPhotoViewModel.getPhotos().observe(this, new Observer<PagedList<PhotoEntity>>() {
            @Override
            public void onChanged(PagedList<PhotoEntity> photoEntities) {
                mPhotoAdapter.submitList(photoEntities);
            }
        });
    }
}
