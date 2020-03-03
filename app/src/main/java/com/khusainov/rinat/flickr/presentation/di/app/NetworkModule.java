package com.khusainov.rinat.flickr.presentation.di.app;

import com.google.gson.Gson;
import com.khusainov.rinat.flickr.BuildConfig;
import com.khusainov.rinat.flickr.Constants;
import com.khusainov.rinat.flickr.data.api.ApiKeyInterceptor;
import com.khusainov.rinat.flickr.data.api.FlickrApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Модуль внедренения зависимостей для работы с сетью
 */
@Module
public class NetworkModule {

    /**
     * @return возвращает экземпляр Gson
     */
    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    /**
     * @return возвращает экземпляр OkHttpClient
     */
    @Provides
    @Singleton
    OkHttpClient provideClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(new ApiKeyInterceptor());
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        return builder.build();
    }

    /**
     * @return возвращает экземпляр Retrofit
     */
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                // need for interceptors
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * @return возвращает экземпляр FlickrApi для сетевых запросов к web api
     */
    @Provides
    @Singleton
    FlickrApi provideApi(Retrofit retrofit) {
        return retrofit.create(FlickrApi.class);
    }

}
