package com.martin.mvp;

import android.app.Application;
import android.content.Context;

/**
 * 作者：MartinBZDQSM on 2016/9/14 0014.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class MvpApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }

}
