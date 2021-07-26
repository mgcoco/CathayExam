package com.marcus.cathay.ui.paviliondetail

import android.content.Context
import com.marcus.basic.Constants
import com.marcus.basic.data.local.ImageData
import com.marcus.basic.data.response.BaseResultModel
import com.marcus.basic.network.HttpCallback
import com.marcus.basic.network.HttpHelper
import com.marcus.basic.presenter.BasePresenter
import com.marcus.basic.util.IntentUtil
import com.marcus.cathay.LocalConstans
import com.marcus.cathay.data.response.GetPlantListResp
import com.marcus.cathay.data.response.PavilionDetail
import com.marcus.cathay.repository.NetworkRepository
import javax.inject.Inject


class PavilionDetailPresenter @Inject constructor(var contractView: PavilionDetailContract.IPavilionDetailView):
    BasePresenter(contractView, NetworkRepository), PavilionDetailContract.IPavilionDetailPresenter {

    var pavilionDetail: PavilionDetail? = null

    override fun getPlantList(location: String, isRefresh: Boolean) {
        if(listQuery.q != location || isRefresh) {
            currentOffset = 0
            listQuery.q = location!!
        }
        listQuery.offset = currentOffset

        NetworkRepository.getPlantList(query = listQuery, callback = object : HttpCallback<BaseResultModel<GetPlantListResp>>(contractView) {
                override fun onSuccess(response: BaseResultModel<GetPlantListResp>) {

                    currentOffset += response.result?.results!!.size!!

                    if(response.result?.results!!.isEmpty() || response.result?.results!!.size < Constants.DEFAULT_LIST_LIMIT) {
                        contractView.addPlantDetail(response.result?.results!!, true)
                    }
                    else{
                        contractView.addPlantDetail(response.result?.results!!, false)
                    }
                }
            })
    }

    override fun openInBrowser(context: Context, url: String){
        IntentUtil.openUrl(context, url)
    }

    override fun viewPavilionFullImage() {
        println("=======>viewPavilionFullImage:")
        var imageData = ImageData(
            title = pavilionDetail?.name,
            description = pavilionDetail?.description,
            url = pavilionDetail?.picture
        )
        contractView.viewFullImage(imageData)
    }
}