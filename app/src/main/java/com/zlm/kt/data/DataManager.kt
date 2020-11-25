package com.zlm.kt.data

import android.content.Context
import com.zlm.kt.connect.ApiClientImp
import com.zlm.kt.connect.ApiService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Milla
 * @create 2020/3/29
 */
@Singleton
class DataManager
    @Inject
    constructor(
        override val context: Context, private val apiClient: ApiClientImp) : DataManagerImp {

    override val api: ApiService
        get() = apiClient.api

}