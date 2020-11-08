package com.sematec.basic.video_player

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.sematec.basic.R
import com.sematec.basic.utils.AppUtils
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {
    lateinit var receiver  :BroadcastReceiver
    val videoURL =
        "https://as3.cdn.asset.aparat.com/aparat-video/9c7383e3c67dce6cc4aaaca8a44f8d6213671911-144p.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

//        val uri = Uri.parse(videoURL)
//
//        videoView.setVideoURI(uri)
//        videoView.setMediaController(MediaController(this))
//
//        if (AppUtils.getNumberByHawk("video_position") > 0) {
//            videoView.seekTo(AppUtils.getNumberByHawk("video_position"))
//        }
//        videoView.start()

        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.READ_PHONE_STATE,
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                }

            }).check()


        val intentFilter = IntentFilter("android.intent.action.PHONE_STATE")
        receiver = object :BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                "OnReceie".toast()
            }
        }
        registerReceiver(receiver,intentFilter)


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onPause() {
        super.onPause()
        AppUtils.saveNumberInHawk("video_position", videoView.currentPosition)
    }
}