package com.khusainov.rinat.flickr.presentation.ui.home.view;

import android.content.Context;
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
import com.khusainov.rinat.flickr.presentation.AppDelegate;
import com.khusainov.rinat.flickr.presentation.ui.detail.view.DetailFragment;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoFactory;
import com.khusainov.rinat.flickr.presentation.ui.home.viewmodel.PhotoViewModel;

public class HomeFragment extends Fragment {

    private PhotoFactory mPhotoFactory;
    private PhotoViewModel mPhotoViewModel;
    private RecyclerView mPhotoRecyclerView;
    private PhotoAdapter mPhotoAdapter;

    private PhotoAdapter.OnItemClickListener mOnItemClickListener = new PhotoAdapter.OnItemClickListener() {
        @Override
        public void onClick(String photoId) {
            if (getFragmentManager() != null) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, DetailFragment.newInstance(photoId))
                        .addToBackStack(null)
                        .commit();
            }
        }
    };

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
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

        mPhotoAdapter = new PhotoAdapter(mOnItemClickListener);
        mPhotoFactory = AppDelegate.getGalleryComponent().getPhotoFactory();

        setupMvvm();
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mPhotoRecyclerView.setAdapter(mPhotoAdapter);
    }

    private void setupMvvm() {
        mPhotoViewModel = new ViewModelProvider(this, mPhotoFactory).get(PhotoViewModel.class);
        mPhotoViewModel.getPhotos().observe(this, new Observer<PagedList<PhotoEntity>>() {
            @Override
            public void onChanged(PagedList<PhotoEntity> photoEntities) {
                mPhotoAdapter.submitList(photoEntities);
            }
        });
    }
}
