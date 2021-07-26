package com.marcus.basic.ui

import android.graphics.Color
import android.text.method.ScrollingMovementMethod
import com.marcus.basic.Constants
import com.marcus.basic.R
import com.marcus.basic.data.local.ImageData
import com.marcus.basic.databinding.ActivityImageViewerBinding
import com.marcus.basic.ui.base.BaseActivity


class ImageViewerActivity: BaseActivity<ActivityImageViewerBinding>() {

    companion object {
        const val BUNDLE_IMAGE_DATA = "BUNDLE_IMAGE_DATA"
    }

    override fun initialUi() {

        var imageData = intent.getBundleExtra(Constants.Extra.BUNDLE_EXTRA).getParcelable<ImageData>(
            BUNDLE_IMAGE_DATA
        )
        if(imageData != null) {
            binding.data = imageData
        }
        binding.description.movementMethod = ScrollingMovementMethod()
        binding.toolbar.navigationIcon?.setTint(Color.WHITE)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.description.isScrollbarFadingEnabled = false
        binding.toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    override fun loadData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_image_viewer
    }
}