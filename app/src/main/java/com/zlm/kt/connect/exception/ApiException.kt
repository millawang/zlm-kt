package com.zlm.kt.connect.exception

/**
 * @author Milla
 * @create 2020/3/27
 */
class ApiException // -------------------------------------------
(// -------------------------------------------
        var code: Int, // -------------------------------------------
        var msg: String?) : Exception(msg)