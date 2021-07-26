package com.marcus.basic.data.response

import com.google.gson.annotations.SerializedName


open class BaseResultModel<Result> {
    @SerializedName("result") var result: Result? = null
}