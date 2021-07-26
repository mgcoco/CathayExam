package com.marcus.basic.widget

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.marcus.basic.R

object XmlBinds {
    @BindingAdapter("selected")
    @JvmStatic
    fun setSelected(view: View, isSelected: Boolean) {
        view.isSelected = isSelected
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, imageUrl: String?) {
        Glide.with(view.context)
            .load(imageUrl)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder_broken)
            .into(view)
    }
}