package com.marcus.cathay.data.response

import com.google.gson.annotations.SerializedName
import com.marcus.basic.data.response.BaseListModel

data class GetPavilionListResp(
    @SerializedName("results") var results: ArrayList<PavilionDetail> = arrayListOf()
) : BaseListModel()