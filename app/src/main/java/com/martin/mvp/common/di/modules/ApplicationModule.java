package com.martin.mvp.common.di.modules;

import android.content.Context;

import com.martin.mvp.MvpApplication;
import com.martin.mvp.common.di.scope.ContextLife;
import com.martin.mvp.common.di.scope.PreApp;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：提供
 */
@Module
public class ApplicationModule {
    private MvpApplication mApplication;

    public ApplicationModule(MvpApplication application) {
        mApplication = application;
    }

    @Provides
    @PreApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

}