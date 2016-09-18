package com.martin.mvp.common.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.martin.mvp.common.di.scope.ContextLife;
import com.martin.mvp.common.di.scope.PreFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PreFragment
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mFragment.getActivity();
    }

    @Provides
    @PreFragment
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PreFragment
    public Fragment provideFragment() {
        return mFragment;
    }

}
