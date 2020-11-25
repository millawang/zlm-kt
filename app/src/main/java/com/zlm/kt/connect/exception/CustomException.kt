package com.zlm.kt.connect.exception

import android.net.ParseException
import com.google.gson.JsonParseException
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author Milla
 * @create 2020/3/27
 */
object CustomException {
    /**
     * Unknown error.
     */
    const val UNKNOWN = 1000

    /**
     * Parse error.
     */
    const val PARSE_ERROR = 1001

    /**
     * Network error.
     */
    const val NETWORK_ERROR = 1002

    // -------------------------------------------
    @JvmStatic
    fun handleException(e: Throwable): ApiException {
        val ex: ApiException
        return if (e is JsonParseException
                || e is JSONException
                || e is ParseException) {
            ex = ApiException(PARSE_ERROR, e.message)
            ex
        } else if (e is ConnectException) {
            ex = ApiException(NETWORK_ERROR, e.message)
            ex
        } else if (e is UnknownHostException || e is SocketTimeoutException) {
            ex = ApiException(NETWORK_ERROR, e.message)
            ex
        } else {
            ex = ApiException(UNKNOWN, e.message)
            ex
        }
    } // -------------------------------------------
}