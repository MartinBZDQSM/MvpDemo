package com.martin.mvp.common.di.component;

import android.app.Activity;
import android.content.Context;

import com.martin.mvp.common.di.modules.FragmentModule;
import com.martin.mvp.common.di.scope.ContextLife;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
@Singleton
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentCompoent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();
}
