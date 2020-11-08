package com.sematec.basic.dialog

import android.app.Dialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.sematec.basic.R
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_alert_dialog.*

class AlertDialogActivity : AppCompatActivity() {

    lateinit var progressDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_alert_dialog)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        removeAll.setOnClickListener {
            //showConfirmation()

            progressDialog.show()
        }

    }

    override fun onBackPressed() {

    }


    private fun showConfirmation() {
        val builder = AlertDialog.Builder(this)

        builder.setMessage("Confirm remove files")

            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
                "ok clicked".toast()

            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
                "no clicked".toast()
            }.create().show()

    }
}