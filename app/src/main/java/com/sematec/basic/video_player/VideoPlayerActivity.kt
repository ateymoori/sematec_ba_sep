package com.sematec.basic.video_player

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.sematec.basic.R
import com.sematec.basic.utils.AppUtils
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    val videoURL =
        "https://as3.cdn.asset.aparat.com/aparat-video/9c7383e3c67dce6cc4aaaca8a44f8d6213671911-144p.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val uri = Uri.parse(videoURL)

        videoView.setVideoURI(uri)
        videoView.setMediaController(MediaController(this))

        if (AppUtils.getNumberByHawk("video_position") > 0) {
            videoView.seekTo(AppUtils.getNumberByHawk("video_position"))
        }
        videoView.start()


    }

    override fun onPause() {
        super.onPause()
        AppUtils.saveNumberInHawk("video_position", videoView.currentPosition)
    }
}