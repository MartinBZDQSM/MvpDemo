package com.martin.mvp.common.base.presenter;

import android.support.annotation.NonNull;

import com.martin.mvp.common.base.view.BaseView;

/**
 * 作者：MartinBZDQSM on 2016/9/18 0018.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public interface BasePresenter {

    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();

}
