package com.martin.mvp.common.di.services;

import com.martin.mvp.function.message.model.Message;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by MartinBZDQSM on 2016/9/12.
 * 博客: http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：结合rxjava ，返回对应的Observable对象
 */
public interface ApiService {


    @FormUrlEncoded
    @GET("data/{type}/{num}/{page}")
    Observable<Message> getMessageList(@Path("type") String type, @Path("num") int num, @Path("page") int page);

}
