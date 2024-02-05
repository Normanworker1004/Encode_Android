package com.sweetwater.encore.utilities

import android.util.Log
import com.sweetwater.encore.BuildConfig
import javax.inject.Inject

class Logger @Inject constructor() {

    fun d(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg)
        }
    }

    fun e(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg)
        }
    }
}