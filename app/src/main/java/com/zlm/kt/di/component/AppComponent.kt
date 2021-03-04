package com.zlm.kt.di.component

import android.app.Application
import com.zlm.kt.di.builder.ActivityBuilder
import com.zlm.kt.di.module.AppModule
import com.zlm.kt.other.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * @author Milla
 * @create 2020/3/29
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {
    // -------------------------------------------
    //fun inject(app: MyApplication?)

    // -------------------------------------------
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    } // -------------------------------------------

    fun inject(app: MyApplication)
}
