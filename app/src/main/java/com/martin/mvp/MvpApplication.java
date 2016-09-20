package com.martin.mvp;

import android.app.Application;
import android.content.Context;

import com.martin.mvp.common.di.component.ApplicationComponent;
import com.martin.mvp.common.di.modules.ApplicationModule;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class MvpApplication extends Application {

    private static Context mContext;

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        applicationComponentInit();

    }

    private void applicationComponentInit() {
//        applicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(this))
//                .build();
    }

    public static Context getmContext() {
        return mContext;
    }

    public static ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

}
