package com.marcus.cathay.repository

import com.marcus.basic.data.request.ListQueryRequest
import com.marcus.basic.data.response.BaseResultModel
import com.marcus.basic.network.HttpCallback
import com.marcus.basic.network.HttpHelper
import com.marcus.basic.repository.BaseNetworkRepository
import com.marcus.cathay.LocalConstans
import com.marcus.cathay.data.response.GetPavilionListResp
import com.marcus.cathay.data.response.GetPlantListResp

object NetworkRepository: BaseNetworkRepository() {

    fun getPavilionList(query: ListQueryRequest, callback: HttpCallback<BaseResultModel<GetPavilionListResp>>){
        HttpHelper.instance.get(domain = LocalConstans.DOMAIN, route = LocalConstans.Route.GET_PAVALION_LIST, query = query, callback = callback)
    }

    fun getPlantList(query: ListQueryRequest, callback: HttpCallback<BaseResultModel<GetPlantListResp>>){
        HttpHelper.instance.get(domain = LocalConstans.DOMAIN, route = LocalConstans.Route.GET_PLANT_LIST, query = query, callback = callback)
    }
}