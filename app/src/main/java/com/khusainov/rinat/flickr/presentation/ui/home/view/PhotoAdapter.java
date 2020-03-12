package com.khusainov.rinat.flickr.presentation.ui.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.khusainov.rinat.flickr.R;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;

public class PhotoAdapter extends PagedListAdapter<PhotoEntity, PhotoAdapter.PhotoViewHolder> {

    private OnItemClickListener mOnItemClickListener;

    public PhotoAdapter(OnItemClickListener listener) {
        super(DIFF_CALLBACK);
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoEntity photo = getItem(position);
        holder.bind(photo, mOnItemClickListener);
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPhotoImageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            mPhotoImageView = itemView.findViewById(R.id.photo_image_view);
        }

        private void bind(PhotoEntity photo, OnItemClickListener listener) {
            Glide.with(itemView.getContext()).load(parseUrl(photo)).centerCrop().into(mPhotoImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(photo.getId());
                }
            });
        }

        private String parseUrl(PhotoEntity photo) {
            String protocol = "https://";
            String farm = "farm";
            String domain = ".staticflickr.com/";
            String slash = "/";
            String underscore = "_";
            String size = "q";
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

    private static DiffUtil.ItemCallback<PhotoEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<PhotoEntity>() {
                @Override
                public boolean areItemsTheSame(PhotoEntity oldPhotoEntity, PhotoEntity newPhotoEntity) {
                    return oldPhotoEntity.getId() == newPhotoEntity.getId();
                }

                @Override
                public boolean areContentsTheSame(PhotoEntity oldPhotoEntity, PhotoEntity newPhotoEntity) {
                    return oldPhotoEntity.equals(newPhotoEntity);
                }
            };

    public interface OnItemClickListener {
        void onClick(String photoId);
    }
}
