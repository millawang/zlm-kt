package com.zlm.kt.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferenceHelper  {

    // -------------------------------------------
    // is first start application.
    private final String IS_FIRST = "IsFirst";
    // -------------------------------------------
    private SharedPreferences sp;

    // -------------------------------------------
    @Inject
    public PreferenceHelper(Context context, String prefFileName) {
        sp = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
    // -------------------------------------------
    /**
     * Save first open app.
     *
     * @param isFirst false: not first.
     */
    public void setFirst(boolean isFirst) {
        sp.edit().putBoolean(IS_FIRST, isFirst).apply();
    }

    // -------------------------------------------

    /**
     * User is first open app.
     */
    public boolean isFirst() {
        return sp.getBoolean(IS_FIRST, true);
    }

    // -------------------------------------------
}
