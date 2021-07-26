package com.marcus.basic.network

import androidx.annotation.StringDef
import io.reactivex.rxjava3.core.Observer
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

abstract class IHttpProcessor<Query, Body> {

    companion object {
        const val METHOD_GET = "GET"

        const val METHOD_POST = "POST"

        const val METHOD_PUT = "PUT"

        const val METHOD_DELETE = "DELETE"
    }

    @StringDef(METHOD_GET, METHOD_POST, METHOD_PUT, METHOD_DELETE)
    @Retention(RetentionPolicy.SOURCE)
    annotation class RequestMethods

    var runningCountChangeObserver: Observer<Int>? = null

    abstract fun get(
        domain: String,
        route: String,
        header: Map<String, String>? = null,
        query: Query,
        callback: ICallback
    )

    abstract fun post(
        domain: String,
        route: String,
        header: Map<String, String>? = null,
        body: Body,
        callback: ICallback
    )

    abstract fun getExecutingCount(): Int

//    fun put(domain: String, route: String, header : Map<String, String>, body: Object, callback: ICallback)
//
//    fun delete(domain: String, route: String, header : Map<String, String>, body: Object, callback: ICallback)
}