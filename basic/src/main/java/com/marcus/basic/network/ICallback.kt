package com.marcus.basic.network

interface ICallback {

    fun onSuccess(result: String)

    fun onFailure(error: String)
}