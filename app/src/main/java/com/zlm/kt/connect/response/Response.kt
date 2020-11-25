package com.zlm.kt.connect.response

/**
 * @author Milla
 * @create 2020/3/27
 */
class Response<T> {
    // -------------------------------------------
    // -------------------------------------------
    var errorCode = 0
    var errorMsg: String? = null
    var data: T? = null
        private set

    fun setData(data: T) {
        this.data = data
    } // -------------------------------------------
}