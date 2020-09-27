package com.sematec.basic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.orhanobut.hawk.Hawk
import com.sematec.basic.R
import com.sematec.basic.utils.AppUtils
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        Hawk.init(this).build()

//        name_family.setText(getPref("name"))
//        mobile.setText(getPref("mobile"))
         name_family.setText(getByHawk("name"))
         mobile.setText(getByHawk("mobile"))

        save.setOnClickListener {
            val name_val = name_family.text.toString()
            val mobile_val = mobile.text.toString()

//            saveToPref("name", name_val)
//            saveToPref("mobile", mobile_val)

            saveByHawk("name", name_val)
            saveByHawk("mobile", mobile_val)

            AppUtils.toast(this, "Data has been saved")

            name_family.setText("")
            mobile.setText("")
        }

    }

    private fun saveToPref(key: String, value: String) {
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putString(key, value).apply()
    }

    fun getPref(key: String): String? {
        return PreferenceManager.getDefaultSharedPreferences(this)
            .getString(key, null)
    }

    fun saveByHawk(key: String, value: String) {
        Hawk.put(key, value)
    }

    fun getByHawk(key: String): String? {
        return Hawk.get(key)
    }


}