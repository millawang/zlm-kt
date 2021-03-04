package com.zlm.kt.connect

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() : BaseClient(), ApiClientImp {
    // -------------------------------------------
    override val api: ApiService
        get() {
            if (Companion.api == null) {
                synchronized(ApiService::class.java) { Companion.api = createService(ApiService::class.java) }
            }
            return Companion.api
        }

    companion object {
        private lateinit var api: ApiService
    }

    init {
        Companion.api = createService(ApiService::class.java)
    }
}