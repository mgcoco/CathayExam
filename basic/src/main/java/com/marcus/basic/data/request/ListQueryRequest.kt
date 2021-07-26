package com.marcus.basic.data.request

import com.google.gson.annotations.SerializedName
import com.marcus.basic.Constants

data class ListQueryRequest(
    @SerializedName("q") var q: String = "",
    @SerializedName("limit") var limit: Int = Constants.DEFAULT_LIST_LIMIT,
    @SerializedName("offset") var offset: Int = 0,
    @SerializedName("sort") var sort: String = ""
)