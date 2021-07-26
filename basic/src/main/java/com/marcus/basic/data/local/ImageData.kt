package com.marcus.basic.data.local

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class ImageData(
    var title: String? = null,
    var description: String? = null,
    var url: String? = null
): Parcelable