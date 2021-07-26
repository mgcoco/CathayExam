package com.marcus.cathay.data.response

import com.google.gson.annotations.SerializedName
import com.marcus.basic.data.response.BaseListModel

data class GetPlantListResp(
    @SerializedName("results") var results: ArrayList<PlantDetail> = arrayListOf()
) : BaseListModel()