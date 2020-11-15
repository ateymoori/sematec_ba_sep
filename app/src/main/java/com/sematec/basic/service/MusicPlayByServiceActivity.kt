package com.sematec.basic.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import kotlinx.android.synthetic.main.activity_music_play_by_service.*

class MusicPlayByServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_play_by_service)
        val serviceIntent = Intent(this, MusicPlayerService::class.java)

        play.setOnClickListener {
            serviceIntent.putExtra("music_name", "Shajarian")
            startService(serviceIntent)
        }

        pause.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}