package com.martin.mvp.common.di.modules;

import android.app.Activity;
import android.content.Context;

import com.martin.mvp.common.di.scope.ContextLife;
import com.martin.mvp.common.di.scope.PreActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PreActivity
    @ContextLife("Activity")
    public Context ProvideActivityContext() {
        return mActivity;
    }

    @Provides
    @PreActivity
    public Activity ProvideActivity() {
        return mActivity;
    }
}
