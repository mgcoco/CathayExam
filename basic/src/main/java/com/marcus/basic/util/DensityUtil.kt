package com.marcus.basic.util

import android.content.Context
import android.util.DisplayMetrics


object DensityUtil {

    /**
     * Covert dp to px
     * @param dp
     * @param context
     * @return pixel
     */
    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * getDensity(context)
    }

    /**
     * Covert px to dp
     * @param px
     * @param context
     * @return dp
     */
    fun convertPixelToDp(px: Float, context: Context): Float {
        return px / getDensity(context)
    }

    /**
     * 取得螢幕密度
     * 120dpi = 0.75
     * 160dpi = 1 (default)
     * 240dpi = 1.5
     * @param context
     * @return
     */
    private fun getDensity(context: Context): Float {
        return getDisplayMetries(context).density
    }

    private fun getDisplayMetries(context: Context): DisplayMetrics {
        return context.resources.displayMetrics
    }

    fun getScreenHeight(context: Context): Int {
        return getDisplayMetries(context).heightPixels
    }
}