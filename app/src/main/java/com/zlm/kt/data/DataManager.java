package com.zlm.kt.data;

import android.content.Context;

import com.zlm.kt.connect.ApiClientImp;
import com.zlm.kt.connect.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Milla
 * @create 2020/3/29
 */

@Singleton
public class DataManager implements DataManagerImp {

    private final Context context;
    private final ApiClientImp apiClient;

    // -------------------------------------------
    @Inject
    public DataManager(Context context, ApiClientImp apiClient) {
        this.context = context;
        this.apiClient = apiClient;
    }

    // -------------------------------------------
    @Override
    public ApiService getApi() {
        return apiClient.getApi();
    }

    // -------------------------------------------
    @Override
    public Context getContext() {
        return context;
    }

    // -------------------------------------------
}
