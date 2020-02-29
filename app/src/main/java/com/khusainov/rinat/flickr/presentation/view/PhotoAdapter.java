package com.khusainov.rinat.flickr.presentation.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.data.model.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> mPhotos = new ArrayList<>();

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);
        holder.bind(photo);
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public void bindData(List<Photo> photos) {
        mPhotos = new ArrayList<>(photos);
        notifyDataSetChanged();
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPhotoImageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            mPhotoImageView = itemView.findViewById(R.id.photo_image_view);
        }

        private void bind(Photo photo) {
            Glide.with(itemView.getContext()).load(parseUrl(photo)).centerCrop().into(mPhotoImageView);
        }

        private String parseUrl(Photo photo) {
            String protocol = "https://";
            String farm = "farm";
            String domain = ".staticflickr.com/";
            String slash = "/";
            String underscore = "_";
            String size = "z";
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
    }
}
