package com.martin.mvp.common.di.component;

import android.content.Context;

import com.martin.mvp.common.base.presenter.BasePresenter;
import com.martin.mvp.common.di.modules.ApiModules;
import com.martin.mvp.common.di.modules.ApplicationModule;
import com.martin.mvp.common.di.scope.ContextLife;
import com.martin.mvp.common.di.scope.PreApp;

import dagger.Component;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
@PreApp
@Component(modules = {ApiModules.class, ApplicationModule.class})
public interface ApplicationComponent {

    void inject(BasePresenter basePresenter);

    @ContextLife("Application")
    Context getApplication();

}