package com.sematec.basic.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.orhanobut.hawk.Hawk

class AppUtils {
    companion object {
        fun log(msg: String) {
            Log.d("sematec_app_debug", msg)
        }

        fun toast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        fun setData(key: String, value: String?) {
            Hawk.put(key, value)
        }

        fun getData(key: String) = Hawk.get<String>(key)


        fun getNumberByHawk(key: String ):Int  {
            return Hawk.get(key, 0 )
        }
        fun saveNumberInHawk(key: String, value: Int) {
            Hawk.put(key, value)
        }


    }


}