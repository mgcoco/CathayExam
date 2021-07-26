package com.marcus.basic.repository

import com.tencent.mmkv.MMKV

open class BasePreferenceRepository {

    private var kv = MMKV.defaultMMKV()

    companion object {

        @Volatile private var INSTANCE: BasePreferenceRepository? = null

        fun getInstance(): BasePreferenceRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: BasePreferenceRepository().also {
                    INSTANCE = it
                }
            }

    }

    fun putString(key: String, value: String) {
        kv!!.putString(key, value)
    }

    fun getString(key: String): String? {
        return kv!!.decodeString(key)
    }

    fun putInt(key: String, value: Int) {
        kv!!.putInt(key, value)
    }

    fun getInt(key: String, default: Int = -1): Int {
        return kv!!.decodeInt(key, default)
    }

    fun putFloat(key: String, value: Float) {
        kv!!.putFloat(key, value)
    }

    fun getFloat(key: String, default: Float = -1f): Float {
        return kv!!.decodeFloat(key, default)
    }

    fun putLong(key: String, value: Long) {
        kv!!.putLong(key, value)
    }

    fun getLong(key: String, default: Long = -1): Long {
        return kv!!.decodeLong(key, default)
    }

}