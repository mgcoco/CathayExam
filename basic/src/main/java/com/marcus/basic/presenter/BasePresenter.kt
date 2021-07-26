package com.marcus.basic.presenter

import com.marcus.basic.data.request.ListQueryRequest
import com.marcus.basic.repository.BaseNetworkRepository
import com.marcus.basic.ui.base.IBaseView
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

open class BasePresenter {

    var currentOffset : Int = 0

    var listQuery = ListQueryRequest()

    constructor(contractView: IBaseView, networkRepository: BaseNetworkRepository) {
        networkRepository.setRunningObserver(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(count: Int) {
                if(count > 0)
                    contractView.showLoading()
                else
                    contractView.closeLoading()
            }

            override fun onError(e: Throwable) {
            }


            override fun onComplete() {
            }
        })
    }
}