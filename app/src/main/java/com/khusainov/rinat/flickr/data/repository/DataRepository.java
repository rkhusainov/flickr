package com.khusainov.rinat.flickr.data.repository;

import com.khusainov.rinat.flickr.data.model.PhotoResponse;
import com.khusainov.rinat.flickr.domain.mapper.IMapper;
import com.khusainov.rinat.flickr.domain.model.PhotoEntity;
import com.khusainov.rinat.flickr.domain.repository.IDataRepository;
import com.khusainov.rinat.flickr.presentation.utils.ApiUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DataRepository implements IDataRepository {

    private IMapper mMapper;

    public DataRepository(IMapper mapper) {
        mMapper = mapper;
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public Observable<List<PhotoEntity>> getPhotos() {
        return ApiUtils.getApi().getRecentPhotos(1)
                .map(new Function<PhotoResponse, List<PhotoEntity>>() {
                    @Override
                    public List<PhotoEntity> apply(PhotoResponse response) throws Exception {
                        return (List<PhotoEntity>) mMapper.convert(response.getPhotos().getPhoto());
                    }
                });
    }
}
