package com.marcus.cathay.ui.paviliondetail

import android.content.Context
import com.marcus.basic.data.local.ImageData
import com.marcus.basic.presenter.IBasePresenter
import com.marcus.basic.ui.base.IBaseView
import com.marcus.cathay.data.response.PlantDetail

interface PavilionDetailContract {

    interface IPavilionDetailView: IBaseView {
        fun addPlantDetail(list: List<PlantDetail>, noMore: Boolean)

        fun showPlantDetail(detail: PlantDetail)

        fun viewFullImage(imageData: ImageData)
    }

    interface IPavilionDetailPresenter: IBasePresenter {
        fun getPlantList(location: String, isRefresh: Boolean)

        fun openInBrowser(context: Context, url: String)

        fun viewPavilionFullImage()
    }
}