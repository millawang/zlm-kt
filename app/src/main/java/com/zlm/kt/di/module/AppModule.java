package com.zlm.kt.di.module;

import android.app.Application;
import android.content.Context;

import com.zlm.kt.connect.ApiClient;
import com.zlm.kt.connect.ApiClientImp;
import com.zlm.kt.data.DataManager;
import com.zlm.kt.data.DataManagerImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Milla
 * @create 2020/3/29
 */

@Module
public class AppModule {

    // -------------------------------------------
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    // -------------------------------------------
    @Provides
    @Singleton
    DataManagerImp provideDataManager(DataManager dataManager) {
        return dataManager;
    }


    // -------------------------------------------
    @Provides
    @Singleton
    ApiClientImp provideApiClient(ApiClient apiClient) {
        return apiClient;
    }

    // -------------------------------------------

}
