package com.zlm.kt.connect;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiClient extends BaseClient implements ApiClientImp {

    private static  ApiService api;

    @Inject
    public ApiClient() {
        api = createService(ApiService.class);
    }

    // -------------------------------------------
    @Override
    public ApiService getApi() {
        if (api == null) {
            synchronized (ApiService.class) {
                api = createService(ApiService.class);
            }
        }
        return api;
    }

}
