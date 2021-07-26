package com.marcus.basic.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.marcus.basic.Constants
import com.marcus.basic.data.local.ImageData
import com.marcus.basic.ui.ImageViewerActivity


object IntentUtil {

    fun openUrl(context: Context, url: String){
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        context.startActivity(i)
    }

    fun openActivity(context: Context, destination: Class<*>, bundle: Bundle? = null){
        val i = Intent(context, destination)
        i.putExtra(Constants.Extra.BUNDLE_EXTRA, bundle)
        context.startActivity(i)
    }

    fun openImageViewerActivity(context: Context, imageData: ImageData){
        var bundle = Bundle()
        bundle.putParcelable(ImageViewerActivity.BUNDLE_IMAGE_DATA, imageData)
        openActivity(context, ImageViewerActivity::class.java, bundle)
    }
}