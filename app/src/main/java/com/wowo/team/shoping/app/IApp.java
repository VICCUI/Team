package com.wowo.team.shoping.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * author:  崔海
 * time:    2016/7/15 22:22
 * name:
 * overview:
 * usage:
 */
public class IApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .diskCacheSize(30 * 1024 * 1024)
                .memoryCacheSize(20 * 1024 * 1024)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
