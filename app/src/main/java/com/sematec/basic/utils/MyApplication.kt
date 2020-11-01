package com.sematec.basic.utils

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.orhanobut.hawk.Hawk
import com.sematec.basic.BuildConfig
import com.sematec.basic.db.DatabaseHandler
import com.sematec.basic.room.AppDatabase
import timber.log.Timber


class MyApplication : Application() {

    companion object {
        lateinit var context: Context
        lateinit var database: DatabaseHandler
        lateinit var roomDB: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        context = this

        database = DatabaseHandler(context)

        initRoom()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initRoom() {
        roomDB = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "sematec_room.sqlite"
        ).allowMainThreadQueries().build()
        //please don't use allowMainThreadQueries
        //use threads
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}