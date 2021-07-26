package com.marcus.basic.data.response

import com.google.gson.annotations.SerializedName

open class BaseListModel{
    @SerializedName("limit") var limit: Int = 10
    @SerializedName("offset") var offset: Int = 0
    @SerializedName("count") var count: Int = 0
    @SerializedName("sort") var sort: String = ""
}
