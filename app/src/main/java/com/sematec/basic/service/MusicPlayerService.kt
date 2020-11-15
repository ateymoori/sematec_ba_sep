package com.sematec.basic.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.sematec.basic.R
import com.sematec.basic.utils.log
import com.sematec.basic.utils.toast

class MusicPlayerService : Service() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer.create(this, R.raw.wind)
        mediaPlayer.isLooping = false
        "onCreate".log("service_debug")
//        stopSelf()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val myName = intent?.getStringExtra("music_name")
        "onStartCommand".log("service_debug")
        myName?.toast()


        mediaPlayer.start()

        return super.onStartCommand(intent, flags, startId)
    }


    override fun onDestroy() {
        super.onDestroy()

        mediaPlayer.stop()

        "onDestroy".log("service_debug")
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}