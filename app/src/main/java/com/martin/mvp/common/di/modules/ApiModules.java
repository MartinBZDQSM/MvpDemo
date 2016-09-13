package com.martin.mvp.common.di.modules;

import com.martin.mvp.common.config.Constants;
import com.martin.mvp.common.di.services.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by MartinBZDQSM on 2016/9/12.
 * 博客: http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：请求的Module
 */
@Module
public class ApiModules {

    @Singleton
    @Provides
    protected ApiService getApiService(RxJavaCallAdapterFactory callAdapterFactory, FastJsonConverterFactory gsonConverterFactory, OkHttpClient client) {
        return new Retrofit.Builder().addCallAdapterFactory(callAdapterFactory).addConverterFactory(
                gsonConverterFactory).baseUrl(
                Constants.BASE_URL).client(client).build().create(ApiService.class);
    }

    @Singleton
    @Provides
    protected RxJavaCallAdapterFactory getCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    protected FastJsonConverterFactory getFastJsonConverter() {
        return FastJsonConverterFactory.create();
    }

    @Singleton
    @Provides
    protected OkHttpClient getClient() {
        return new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).readTimeout(
                5000, TimeUnit.MILLISECONDS).addInterceptor(new HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY)).build();
    }


}
