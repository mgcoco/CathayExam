package com.marcus.cathay.ui.plantDetail

import com.marcus.basic.data.local.ImageData
import com.marcus.basic.presenter.BasePresenter
import com.marcus.cathay.data.response.PlantDetail
import com.marcus.cathay.repository.NetworkRepository
import javax.inject.Inject

class PlantDetailPresenter @Inject constructor(var contractView: PlantDetailContract.IPlantDetailView):
    BasePresenter(contractView, NetworkRepository), PlantDetailContract.IPlantDetailPresenter {

    var plantDetail: PlantDetail? = null

    override fun viewPavilionFullImage() {
        var imageData = ImageData(
            title = plantDetail?.nameCh,
            description = plantDetail?.feature,
            url = plantDetail?.picture01
        )
        contractView.viewFullImage(imageData)
    }
}