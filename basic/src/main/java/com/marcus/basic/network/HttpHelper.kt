package com.marcus.basic.network

import io.reactivex.rxjava3.core.Observer


class HttpHelper : IHttpProcessor<Any, Any>() {

    private lateinit var httpProcessor: IHttpProcessor<Any, Any>

    companion object {
        val instance = HttpHelper()
    }

    fun init(httpProcessor: IHttpProcessor<Any, Any>) {
        this.httpProcessor = httpProcessor
    }

    fun setRunningObserver(runningCountChangeObserver: Observer<Int>){
        this.httpProcessor.runningCountChangeObserver = runningCountChangeObserver
    }

    override fun get(domain: String, route: String, header: Map<String, String>?, query: Any, callback: ICallback) {
        httpProcessor.get(domain, route, header, query, callback)
    }

    override fun post(domain: String, route: String, header: Map<String, String>?, body: Any, callback: ICallback) {
        httpProcessor.post(domain, route, header, body, callback)
    }

    override fun getExecutingCount(): Int {
//        runningCountObserver.onNext()
        return httpProcessor.getExecutingCount()
    }


//    override fun put(url: String, header: Map<String, String>, body: Object, callback: ICallback) {
//        httpProcessor.put(url, header, body, callback)
//    }
//
//    override fun delete(url: String, header: Map<String, String>, body: Object, callback: ICallback) {
//        httpProcessor.delete(url, header, body, callback)
//    }
}