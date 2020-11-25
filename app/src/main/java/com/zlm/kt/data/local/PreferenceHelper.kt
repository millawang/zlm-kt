package com.zlm.kt.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceHelper @Inject constructor(context: Context, prefFileName: String?) {
    // -------------------------------------------
    // is first start application.
    private val IS_FIRST = "IsFirst"

    // -------------------------------------------
    private val sp: SharedPreferences
    // -------------------------------------------
    // -------------------------------------------
    /**
     * Save first open app.
     *
     * @param isFirst false: not first.
     */
    /**
     * User is first open app.
     */ // -------------------------------------------
    var isFirst: Boolean
        get() = sp.getBoolean(IS_FIRST, true)
        set(isFirst) {
            sp.edit().putBoolean(IS_FIRST, isFirst).apply()
        }

    // -------------------------------------------
    init {
        sp = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }
}