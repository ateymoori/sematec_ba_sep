package com.sematec.basic.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.sematec.basic.R
import com.sematec.basic.utils.toast

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0 , 100 , 0 , "Item1FromKotlin")
        menu?.add(0 , 200 , 0 , "Item2FromKotlin")
        menuInflater.inflate(R.menu.main_menu , menu )

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home ->{
                "home".toast()
            }
            R.id.setting ->{
                "setting".toast()
            }
            R.id.profile ->{
                "profile".toast()
            }
            R.id.logOut ->{
                "logOut".toast()
            }
             100 ->{
                "Item1FromKotlin".toast()
            }
            200 ->{
                "Item2FromKotlin".toast()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}