package com.marcus.cathay.ui.home

import com.marcus.basic.presenter.IBasePresenter
import com.marcus.basic.ui.base.IBaseView
import com.marcus.cathay.data.response.PavilionDetail

interface HomeContract {

    interface IHomeView: IBaseView {
        fun addPavilionDetail(list: List<PavilionDetail>)

        fun showPavilionDetail(detail: PavilionDetail)
    }

    interface IHomePresenter: IBasePresenter {
        fun getPavilionList()
    }

}