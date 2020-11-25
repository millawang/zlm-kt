package com.zlm.kt.data

import android.content.Context
import com.zlm.kt.connect.ApiClientImp

/**
 * @author Milla
 * @create 2020/3/29
 */
interface DataManagerImp : ApiClientImp {
    val context: Context?
}