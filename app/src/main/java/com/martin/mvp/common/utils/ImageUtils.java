package com.martin.mvp.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.martin.mvp.MvpApplication;

import java.util.concurrent.ExecutionException;

/**
 * 作者：MartinBZDQSM on 2016/9/18 0018.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：图片加载的工具类，适应大部分情况的图片加载，目的是为了日后能够更快切换其他的图片框架，
 * 就个人而言我并不太喜欢使用ApplicationContext用于Glide的图片加载，
 * Glide自身是内存回收是与Activity和Fragment的生命周期相关的。
 * 所以Glide的对象获取我使用的是Imageview的Context（与该V的周期是一致的）。
 * 还有一种自定义组件的情况没有清楚。
 */
public class ImageUtils {

    /**
     * 生成一张图并加入框架缓存
     *
     * @param width
     * @param height
     * @param config
     * @return
     */
    public static Bitmap newAndCache(int width, int height, Bitmap.Config config) {
        Bitmap bitmap = Glide.get(MvpApplication.getmContext()).getBitmapPool().get(width, height, config);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(width, height, config);
            Glide.get(MvpApplication.getmContext()).getBitmapPool().put(bitmap);
        }
        return bitmap;
    }

    /**
     * 同步情况下的图片下载，如果需要异步下载需要额外的开线程
     *
     * @param url
     * @return
     */
    public Bitmap getBitmap(String url) {

        try {
            Bitmap bitmap = Glide.with(MvpApplication.getmContext()).load(url).asBitmap().into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();
            return bitmap;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 异步的图片加载，直接设置到ImageView上
     *
     * @param imageView
     * @param url
     */
    public static void loadInIamgeView(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL).
                into(imageView);
    }

    /**
     * 异步的图片加载，直接设置到ImageView上，绑定错误图片的id
     *
     * @param imageView
     * @param url
     * @param errorId
     */
    public static void loadInIamgeView(ImageView imageView, String url, int errorId) {
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(errorId)
                .into(imageView);
    }

    /**
     * 异步的图片加载，直接设置到ImageView上，绑定预置颜色和错误图片的id
     *
     * @param imageView
     * @param url
     * @param placeColor
     * @param errorId
     */
    public static void loadInIamgeView(ImageView imageView, String url, int placeColor, int errorId) {
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(placeColor)
                .error(errorId)
                .into(imageView);
    }

    /**
     * 清除内存，当然并不会及时回收
     *
     * @param context
     */
    public static void clearMemoryCache(Context context) {
        Glide.get(context).clearMemory();
    }


}
