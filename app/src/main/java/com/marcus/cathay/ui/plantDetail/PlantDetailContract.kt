package com.marcus.cathay.ui.plantDetail

import com.marcus.basic.data.local.ImageData
import com.marcus.basic.presenter.IBasePresenter
import com.marcus.basic.ui.base.IBaseView

interface PlantDetailContract {

    interface IPlantDetailView: IBaseView {
        fun viewFullImage(imageData: ImageData)
    }

    interface IPlantDetailPresenter: IBasePresenter {
        fun viewPavilionFullImage()
    }
}