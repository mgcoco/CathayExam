package com.marcus.basic.repository

import com.marcus.basic.network.HttpHelper
import io.reactivex.rxjava3.core.Observer

open class BaseNetworkRepository {

    fun setRunningObserver(observer: Observer<Int>) {
        HttpHelper.instance.setRunningObserver(observer)
    }

}