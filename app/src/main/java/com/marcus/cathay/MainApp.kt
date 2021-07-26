package com.marcus.cathay

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.marcus.basic.network.HttpHelper
import com.marcus.basic.network.IHttpProcessor
import com.marcus.basic.network.OkhttpProcessor
import com.marcus.basic.util.LogUtil
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp
import me.jessyan.autosize.AutoSize

@HiltAndroidApp
open class MainApp : Application() {

    companion object {
        lateinit var application: MainApp
    }

    override fun attachBaseContext(base: Context?) {
        MultiDex.install(this)
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        val rootDir = MMKV.initialize(this)
        LogUtil.logDebug("mmkv root: $rootDir")

        AutoSize.initCompatMultiProcess(this)

        HttpHelper.instance.init(OkhttpProcessor() as IHttpProcessor<Any, Any>)

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
        ARouter.printStackTrace()
    }

}
