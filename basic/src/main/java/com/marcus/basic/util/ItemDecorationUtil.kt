package com.marcus.basic.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.marcus.basic.R
import com.marcus.basic.widget.HorizontalItemDecoration

object ItemDecorationUtil {

    fun getDefaultDecoration(context: Context): RecyclerView.ItemDecoration {
        return HorizontalItemDecoration(
            ContextCompat.getColor(context,
                R.color.color_bg_gray
            ),
            DensityUtil.convertDpToPixel(1f, context)
        )
    }
}