package com.marcus.basic.network

import com.marcus.basic.data.request.BaseRequest
import okhttp3.*
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.io.IOException


class OkhttpProcessor : IHttpProcessor<Object, BaseRequest>() {

    private val okhttpClient = OkHttpClient()

    private val runningCalls = arrayListOf<Call>()

    override fun get(
        domain: String,
        route: String,
        header: Map<String, String>?,
        query: Object,
        callback: ICallback
    ) {
        var urlBuilder: HttpUrl.Builder = createUrl(domain, route)
        var fields = query::class.java.declaredFields
        for(field in fields) {
            field.isAccessible = true
            urlBuilder = urlBuilder.addQueryParameter(field.name, field.get(query).toString())
        }
        handleEnqueue(getOkhttp(METHOD_GET, createOkhttpClient(urlBuilder.build(), header)), callback)
    }

    override fun post(
        domain: String,
        route: String,
        header: Map<String, String>?,
        body: BaseRequest,
        callback: ICallback
    ) {
        handleEnqueue(getOkhttp(METHOD_POST, createOkhttpClient(createUrl(domain, route).build(), header)), callback)
    }

    private fun createUrl(domain: String, route: String): HttpUrl.Builder{
        return (domain + route).toHttpUrlOrNull()!!.newBuilder()
    }

    private fun handleEnqueue(call: Call, callback: ICallback){
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runningCalls.remove(call)
                if(e.message != null)
                    callback.onFailure(e.message!!)
                else
                    callback.onFailure("Request data failure")
                runningCountChangeObserver?.onNext(getExecutingCount())
            }

            override fun onResponse(call: Call, response: Response) {
                runningCalls.remove(call)
                if (response.isSuccessful) {
                    callback.onSuccess(response.body!!.string())
                } else {
                    callback.onFailure(response.body!!.string())
                }
                runningCountChangeObserver?.onNext(getExecutingCount())
            }
        })
        runningCalls.add(call)
        runningCountChangeObserver?.onNext(getExecutingCount())
    }
    //    override fun put(url: String, header: Map<String, String>, body: Object, callback: ICallback) {
//        TODO("Not yet implemented")
//    }
//
//    override fun delete(url: String, header: Map<String, String>, body: Object, callback: ICallback) {
//        TODO("Not yet implemented")
//    }


    override fun getExecutingCount(): Int {
        return runningCalls.size
    }

    private fun createOkhttpClient(url: HttpUrl, header: Map<String, String>?): Request.Builder {
        val builder = Request.Builder()
        if (header?.isNotEmpty() == true) {
            for ((key, value) in header.entries) {
                builder.addHeader(key, value)
            }
        }
        return builder.url(url)
    }

    private fun getOkhttp(@RequestMethods method: String, requestBuilder: Request.Builder, body: BaseRequest? = null): Call {
        var builder: Request.Builder = requestBuilder
        when(method) {
            METHOD_GET -> {
                builder = requestBuilder.get()
            }
            METHOD_POST -> {
                builder = requestBuilder.post(body!!.getFiled())
            }
            METHOD_PUT -> {
                builder = requestBuilder.put(body!!.getFiled())
            }
            METHOD_DELETE -> {
                builder = requestBuilder.delete(body!!.getFiled())
            }
        }
        return okhttpClient.newCall(builder.build())
    }

}