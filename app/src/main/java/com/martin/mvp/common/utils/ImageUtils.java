package com.martin.mvp.common.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * 作者：MartinBZDQSM on 2016/9/18 0018.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：图片加载的工具类，适应大部分情况的图片加载，目的是为了日后能够更快切换其他的图片框架
 */
public interface ImageUtils {

    /**
     * 同步情况下的图片下载，如果需要异步下载需要额外的开线程
     * @param url
     * @return
     */
    Bitmap getBitmap(String url);

    /**
     * 同步情况下的图片下载，如果需要异步下载需要额外的开线程
     * @param url
     * @return
     */
    Drawable getDrawable(String url);

    /**
     * 异步的图片加载，直接设置到ImageView上
     * @param imageView
     * @param url
     */
    void loadInIamgeView(ImageView imageView, String url);

    /**
     * 异步的图片加载，直接设置到ImageView上，绑定错误图片的id
     * @param imageView
     * @param url
     * @param errorId
     */
    void loadInIamgeView(ImageView imageView, String url, int errorId);

}
