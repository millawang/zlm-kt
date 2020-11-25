package com.zlm.kt.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author Milla
 * @create 2020/11/25
 */
object NetworkUtil {
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (cm != null) {
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
        return false
    }
}