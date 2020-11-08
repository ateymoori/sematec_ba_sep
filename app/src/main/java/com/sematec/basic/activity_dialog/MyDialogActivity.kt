package com.sematec.basic.activity_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.sematec.basic.R
import com.sematec.basic.utils.BaseActivity

class MyDialogActivity : BaseActivity(isDialog = true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dialog)


    }
}