package com.sematec.basic.receiver

import android.Manifest.permission.READ_PHONE_STATE
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.sematec.basic.R
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_receiver_video_player.*
import java.util.jar.Manifest


class ReceiverVideoPlayerActivity : AppCompatActivity() {

    val uri = Uri.parse("https://hw2.cdn.asset.aparat.com/aparat-video/599b4332365c3a94184dbc5a34e0163626685225-144p.mp4")
    val PHONE_STATE_PERMISSION_CODE = 1000
    lateinit var incomingCallReceiver :BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_video_player)

       // getPhoneStatePermission()
        getPermissionByDexter()


        video.setVideoURI(uri)
        video.setMediaController(MediaController(this))
        video.start()

        val intentFilter = IntentFilter("android.intent.action.PHONE_STATE")

        incomingCallReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                "onIncomingCall".toast()
            }
        }

        registerReceiver(incomingCallReceiver , intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(incomingCallReceiver)
    }


    fun getPermissionByDexter(){
        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.READ_PHONE_STATE,
                android.Manifest.permission.READ_CONTACTS
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                    val name = "AmirHossein"

                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) { /* ... */
                }
            }).check()
    }

    fun getPhoneStatePermission(){
        if(ContextCompat.checkSelfPermission(this ,
                READ_PHONE_STATE )
        == PackageManager.PERMISSION_GRANTED){
        //permission is granted
        }else{
            //need to get permission
            ActivityCompat.requestPermissions(this ,
            arrayOf(READ_PHONE_STATE) , PHONE_STATE_PERMISSION_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if( requestCode==PHONE_STATE_PERMISSION_CODE){

        }
    }
}