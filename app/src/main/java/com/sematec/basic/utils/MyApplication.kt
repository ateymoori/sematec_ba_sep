package com.sematec.basic.utils

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk

class MyApplication : Application() {

    companion object {
        lateinit var userNameFamily: String
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        context = this
        userNameFamily = "AmirHossein Teymoori"
    }


    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}