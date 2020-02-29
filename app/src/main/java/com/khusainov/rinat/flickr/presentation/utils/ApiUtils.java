package com.khusainov.rinat.flickr.presentation.utils;

import com.google.gson.Gson;
import com.khusainov.rinat.flickr.BuildConfig;
import com.khusainov.rinat.flickr.Constants;
import com.khusainov.rinat.flickr.data.api.ApiKeyInterceptor;
import com.khusainov.rinat.flickr.data.api.FlickrApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Класс для работы с сетью
 *
 * @author Хусаинов Ринат on 2020-02-28
 */
public class ApiUtils {
    private static OkHttpClient sClient;
    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static FlickrApi sApi;

    private static OkHttpClient getClient() {
        if (sClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.addInterceptor(new ApiKeyInterceptor());
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.level(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(logging);
            }
            sClient = builder.build();
        }
        return sClient;
    }

    /**
     * @return возвращает экземпляр Retrofit
     */
    private static Retrofit getRetrofit() {
        if (sGson == null) {
            sGson = new Gson();
        }

        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_URL)
                    // need for interceptors
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    /**
     * @return возвращает экземпляр FlickrApi для сетевых запросов к web api
     */
    public static FlickrApi getApi() {
        if (sApi == null) {
            sApi = getRetrofit().create(FlickrApi.class);
        }
        return sApi;
    }
}
