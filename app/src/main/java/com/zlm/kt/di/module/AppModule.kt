package com.zlm.kt.di.module

import android.app.Application
import android.content.Context
import com.zlm.kt.connect.ApiClient
import com.zlm.kt.connect.ApiClientImp
import com.zlm.kt.data.DataManager
import com.zlm.kt.data.DataManagerImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Milla
 * @create 2020/3/29
 */
@Module
class AppModule {
    // -------------------------------------------
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    // -------------------------------------------
    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManager): DataManagerImp {
        return dataManager
    }

    // -------------------------------------------
    @Provides
    @Singleton
    fun provideApiClient(apiClient: ApiClient): ApiClientImp {
        return apiClient
    } // -------------------------------------------
}