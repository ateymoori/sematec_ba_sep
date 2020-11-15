package com.sematec.basic.cv

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.sematec.basic.R

class DownloadService : Service() {

//    lateinit var musicPlayer: MediaPlayer
//
//    override fun onCreate() {
//        super.onCreate()
//        musicPlayer = MediaPlayer.create(this, R.raw.wind);
//        musicPlayer.isLooping = false;
//       // stopSelf()
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        musicPlayer.start();
//        return super.onStartCommand(intent, flags, startId)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        musicPlayer.stop()
//    }
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}