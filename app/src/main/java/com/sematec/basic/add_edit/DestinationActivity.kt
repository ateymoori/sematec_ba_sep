package com.sematec.basic.add_edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.utils.Constants.Companion.EDIT_MODE
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_destination2.*

class DestinationActivity : AppCompatActivity() {

    var editMod = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination2)

        editMod = intent.getBooleanExtra(EDIT_MODE, false)

        if (editMod) {
           username.setText("amirhossein")
        } else {
            username.setText("")
        }

        save.setOnClickListener {
            handleSave(editMod)
        }

    }

    private fun handleSave(editMod: Boolean) {
        if (editMod) {
            "modify data and show in the list".toast()
        } else {
            "add new data in DB".toast()
        }
    }
}