package com.khusainov.rinat.flickr.presentation.ui.detail.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.domain.model.PhotoInfoEntity;
import com.khusainov.rinat.flickr.presentation.AppDelegate;
import com.khusainov.rinat.flickr.presentation.ui.detail.viewmodel.PhotoInfoViewModel;
import com.khusainov.rinat.flickr.presentation.ui.factory.PhotoInfoFactory;

public class DetailFragment extends Fragment {

    public static final String PHOTO_KEY = "PHOTO_KEY";
    private String mPhotoId;
    private TextView mUsernameTextView;
    private TextView mTitleTextView;
    private PhotoView mPhotoView;
    private PhotoInfoFactory mPhotoInfoFactory;

    public static DetailFragment newInstance(String photoID) {

        Bundle args = new Bundle();
        args.putString(PHOTO_KEY, photoID);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (getArguments() != null) {
            mPhotoId = getArguments().getString(PHOTO_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mUsernameTextView = view.findViewById(R.id.username_text_view);
        mTitleTextView = view.findViewById(R.id.title_text_view);
        mPhotoView = view.findViewById(R.id.photo_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupMvvm();
    }

    private void setupMvvm() {
        mPhotoInfoFactory = AppDelegate.getDetailComponent().getPhotoInfoFactory();
        PhotoInfoViewModel photoInfoViewModel = new ViewModelProvider(this, mPhotoInfoFactory).get(PhotoInfoViewModel.class);
        photoInfoViewModel.getPhotoInfo(mPhotoId);
        photoInfoViewModel.getPhotoInfo().observe(this, new Observer<PhotoInfoEntity>() {
            @Override
            public void onChanged(PhotoInfoEntity photoInfoEntity) {
                mUsernameTextView.setText(photoInfoEntity.getOwner().getUsername());
                mTitleTextView.setText(photoInfoEntity.getTitle().getContent());
                Glide.with(requireContext()).load(parseUrl(photoInfoEntity)).into(mPhotoView);
            }
        });
    }

    private String parseUrl(PhotoInfoEntity photo) {
        String protocol = "https://";
        String farm = "farm";
        String domain = ".staticflickr.com/";
        String slash = "/";
        String underscore = "_";
        String size = "b";
        String image_format = ".jpg";
        String url = protocol +
                farm +
                photo.getFarm() +
                domain +
                photo.getServer() + slash +
                photo.getId() + underscore +
                photo.getSecret() + underscore +
                size +
                image_format;
        return url;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        AppDelegate.destroyDetailComponent();
    }
}
