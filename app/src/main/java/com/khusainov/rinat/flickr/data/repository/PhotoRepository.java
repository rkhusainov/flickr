package com.khusainov.rinat.flickr.data.repository;

import com.khusainov.rinat.flickr.data.api.FlickrApi;
import com.khusainov.rinat.flickr.data.model.PhotoResponse;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.domain.repository.IPhotoRepository;
import com.khusainov.rinat.flickr.presentation.AppDelegate;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class PhotoRepository implements IPhotoRepository {

    private FlickrApi mApi;
    private IMapper mMapper;

    public PhotoRepository(IMapper mapper) {
        mMapper = mapper;
        mApi = AppDelegate.getHomeComponent().getApi();
    }

    @Override
    public Observable<List<PhotoEntity>> getPhotoEntity(int page, int pageSize) {
        return mApi.getRecentPhotos(page, pageSize)
                .map(new Function<PhotoResponse, List<PhotoEntity>>() {
                    @Override
                    public List<PhotoEntity> apply(PhotoResponse response) throws Exception {
                        return (List<PhotoEntity>) mMapper.convert(response.getPhotos().getPhoto());
                    }
                });
    }
}
