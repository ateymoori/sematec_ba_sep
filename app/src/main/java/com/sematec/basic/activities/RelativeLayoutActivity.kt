package com.sematec.basic.activities

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sematec.basic.R
import kotlinx.android.synthetic.main.register_form.*

class RelativeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_form)

        val openSansFont = Typeface.createFromAsset(
            assets , "fonts/open_sans_bold.ttf"
        )

//        val pageTitle: TextView = findViewById(R.id.pageTitle)
//        pageTitle.setText("AmirHossein")
//        pageTitle.text = "Alireza"

        pageTitle.text = "Maryam"

        pageTitle.typeface = openSansFont



        registerBtn.setOnClickListener {
            val realNameValue = realName.text
            pageTitle.text = realNameValue

            registerContainer.visibility = View.GONE

        }


    }
}