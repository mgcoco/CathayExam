package com.marcus.basic.network

import com.google.gson.Gson
import com.marcus.basic.ui.base.IBaseView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

abstract class HttpCallback<Response>(private var mvpView: IBaseView?): ICallback {

    override fun onSuccess(result: String) {
        var clz = analysisClassInfo(this)
        GlobalScope.launch(Dispatchers.Main) {
            onSuccess(Gson().fromJson<Response>(result, clz))
        }
    }

    abstract fun onSuccess(response: Response)

    override fun onFailure(error: String) {
        mvpView?.showMessage(error)
    }

    private fun analysisClassInfo(obj: Any): Type {
        var type = obj.javaClass.genericSuperclass
        var params = (type as ParameterizedType).actualTypeArguments
        return params[0]
    }
}