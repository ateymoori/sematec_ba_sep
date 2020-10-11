package com.sematec.basic.utils

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk
import com.sematec.basic.BuildConfig
import timber.log.Timber


class MyApplication : Application() {

    companion object {
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        context = this

        if( BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

    }


    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}