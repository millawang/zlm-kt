package com.zlm.kt.di.component;

import android.app.Application;

import com.zlm.kt.di.builder.ActivityBuilder;
import com.zlm.kt.di.module.AppModule;
import com.zlm.kt.other.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * @author Milla
 * @create 2020/3/29
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    // -------------------------------------------
    void inject(MyApplication app);

    // -------------------------------------------
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    // -------------------------------------------
}
