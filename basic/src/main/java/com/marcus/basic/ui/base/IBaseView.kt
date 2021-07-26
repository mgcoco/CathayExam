package com.marcus.basic.ui.base

interface IBaseView {

    fun showLoading()

    fun closeLoading()

    fun showMessage(msg: String?)
}