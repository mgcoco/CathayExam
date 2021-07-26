package com.marcus.cathay.ui.home

import com.marcus.basic.data.response.BaseResultModel
import com.marcus.basic.network.HttpCallback
import com.marcus.basic.presenter.BasePresenter
import com.marcus.cathay.data.response.GetPavilionListResp
import com.marcus.cathay.repository.NetworkRepository
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class HomePresenter @Inject constructor(var contractView: HomeContract.IHomeView):
    BasePresenter(contractView, NetworkRepository), HomeContract.IHomePresenter {

    override fun getPavilionList() {
        listQuery.limit = 100
        NetworkRepository.getPavilionList(query = listQuery, callback = object : HttpCallback<BaseResultModel<GetPavilionListResp>>(contractView) {
            override fun onSuccess(response: BaseResultModel<GetPavilionListResp>) {
                contractView.addPavilionDetail(response.result?.results!!)
            }
        })
    }

}