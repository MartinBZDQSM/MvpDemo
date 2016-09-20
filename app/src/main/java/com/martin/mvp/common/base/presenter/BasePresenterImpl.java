package com.martin.mvp.common.base.presenter;

import android.support.annotation.NonNull;

import com.martin.mvp.common.base.view.BaseView;
import com.martin.mvp.common.di.services.ApiService;

import javax.inject.Inject;

import rx.Subscription;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：
 */
public abstract class BasePresenterImpl implements BasePresenter{

    @Inject
    ApiService mService;

    Subscription subscription;

    public enum RequestMode {
        FRIST, LOAD_MORE, REFRESH
    }

    @Override
    public void onCreate() {

    }


    @Override
    public void attachView(@NonNull BaseView view) {

    }

    @Override
    public void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

    }
}
