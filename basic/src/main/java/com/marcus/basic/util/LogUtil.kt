package com.marcus.basic.util

import android.util.Log

object LogUtil {

    fun logDebug(msg: String? = null, isShowDebug: Boolean? = true) {
        var trace = Throwable().stackTrace
        var className = trace[1].className.substringAfterLast(".")
        val methodName = trace[1].methodName
        if(isShowDebug == true)
            Log.d(className, "method:$methodName|====>${msg?.replace("\\", "")}")
    }

}