package com.marcus.basic.data.request

import com.google.gson.Gson
import com.marcus.basic.util.LogUtil
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.lang.reflect.Field

open class BaseRequest {

    private val DEBUG = false

    private val JSON = "application/json; charset=utf-8".toMediaType()

    open fun getFiled(): RequestBody{
        val fields: Array<Field> = this::class.java.declaredFields
        var map = HashMap<String, Any>()
        putFileds(map, fields)
        LogUtil.logDebug("getFiled:" + fields.size, DEBUG)

        if(this::class.java.superclass != null) {
            LogUtil.logDebug("super classes:" + this::class.java.superclass, DEBUG)
            putFileds(map, this::class.java.superclass?.declaredFields)
        }

        return Gson().toJson(map).toRequestBody(JSON)
    }

    private fun putFileds(map: HashMap<String, Any>, fields: Array<Field>?){
        if(fields == null)
            return
        for (i in fields.indices) {
            fields[i].isAccessible = true
            val value: Any? = fields[i].get(this)
            if(value != null && "CREATOR" != fields[i].name && "DEBUG" != fields[i].name) {
                if(value is String) {
                    if (value.length > 0)
                        map[fields[i].name] = value
                }
                else map[fields[i].name] = value
            }
        }
    }
}