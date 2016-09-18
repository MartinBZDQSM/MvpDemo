package com.martin.mvp.common.config;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.LruResourceCache;

/**
 * 作者：MartinBZDQSM on 2016/9/18 0018.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 说明：Glide的基础配置，继承OkHttpGlideModule，不用再配置okhttp了
 *
 */
public class GlideConfig extends OkHttpGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;
        builder.setMemoryCache(new LruResourceCache(cacheSize));
    }
}
