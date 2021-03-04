package com.zlm.kt.other;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zlm.kt.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import me.yokeyword.fragmentation.BuildConfig;
import me.yokeyword.fragmentation.Fragmentation;


public class MyApplication extends Application implements HasActivityInjector {

    public static Context context;

    // -------------------------------------------
    static {

        ClassicsHeader.REFRESH_HEADER_PULLING = "下拉更新";
        ClassicsHeader.REFRESH_HEADER_REFRESHING = "正在更新...";
        ClassicsHeader.REFRESH_HEADER_LOADING = "正在加載...";
        ClassicsHeader.REFRESH_HEADER_RELEASE = "放開立即更新";
        ClassicsHeader.REFRESH_HEADER_FINISH = "更新完成";
        ClassicsHeader.REFRESH_HEADER_FAILED = "更新失敗";
        ClassicsHeader.REFRESH_HEADER_UPDATE = "上次更新 M-d HH:mm";


    }

    // -------------------------------------------
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    // -------------------------------------------
    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        Logger.addLogAdapter(new AndroidLogAdapter());

        Fragmentation.builder()
                .stackViewMode(Fragmentation.NONE)
                .debug(BuildConfig.DEBUG)
                .handleException(Throwable::printStackTrace)
                .install();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);


    }

    // -------------------------------------------
}
