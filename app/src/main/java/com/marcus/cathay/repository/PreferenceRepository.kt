package com.marcus.cathay.repository

import com.marcus.basic.repository.BasePreferenceRepository

object PreferenceRepository: BasePreferenceRepository() {

    const val LOGIN_TOKEN = "LOGIN_TOKEN"

    fun setToken(token: String){
        return getInstance().putString(LOGIN_TOKEN, token)
    }

    fun getToken(): String?{
        return getInstance().getString(LOGIN_TOKEN)
    }
}