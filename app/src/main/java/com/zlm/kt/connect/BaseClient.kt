package com.zlm.kt.connect

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseClient protected constructor() {
    // -------------------------------------------
    private val DEFAULT_TIME_OUT = 60

    // -------------------------------------------
    private fun init() {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.github.com/")
                .client(builder.build())
                .build()
    }

    companion object {
        private var retrofit: Retrofit? = null
        // -------------------------------------------
        /**
         * create api service.
         *
         * @param service api service
         * @return T
         */
        @JvmStatic
        protected fun <T> createService(service: Class<T>?): T {
            return retrofit!!.create(service)
        } // -------------------------------------------
    }

    // -------------------------------------------
    init {
        init()
    }
}