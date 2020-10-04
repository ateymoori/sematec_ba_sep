package com.sematec.basic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.sematec.basic.R
import com.sematec.basic.adapters.DrawerListAdapter
import com.sematec.basic.entities.DrawerItemEntity
import com.sematec.basic.entities.DrawerItemType
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_nawigation_drawer.*
import kotlinx.android.synthetic.main.drawer_layout.*

class NavigationDrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nawigation_drawer)



        val drawerListValues = mutableListOf<DrawerItemEntity>()

        drawerListValues.add(
            DrawerItemEntity(
                title = "Setting" ,
                icon = R.drawable.ic_baseline_settings_24,
                type = DrawerItemType.SETTING ,
                count = 3
            )
        )
        drawerListValues.add(
            DrawerItemEntity(
                title = "Profile" ,
                icon = R.drawable.ic_baseline_settings_24,
                type = DrawerItemType.PROFILE ,
                count = 6
            )
        )
        drawerListValues.add(
            DrawerItemEntity(
                title = "LogOut" ,
                icon = R.drawable.ic_user_24,
                type = DrawerItemType.LOGOUT ,
                count = 7
            )
        )

        drawerItems.adapter = DrawerListAdapter(this , drawerListValues)

        drawerItems.setOnItemClickListener { adapterView, view, position, l ->
            val item = adapterView.getItemAtPosition(position) as DrawerItemEntity

            if( drawer.isDrawerOpen(Gravity.LEFT)){
                drawer.closeDrawer(Gravity.LEFT)
            }
            when(item.type){
                DrawerItemType.PROFILE -> "PROFILE".toast()
                DrawerItemType.SETTING -> "SETTING".toast()
                DrawerItemType.SUPPORT -> "SUPPORT".toast()
                DrawerItemType.LOGOUT -> "LOGOUT".toast()
            }

        }

        //call Pixabay API
        //Maybe takes 5 minutes
        //will get ANR Error
        //create Background Thread
        //Call API
        //runIOnUIThread ()bridge between bgThread and UI thread

        drawerBTN.setOnClickListener {
            if( !drawer.isDrawerOpen(Gravity.LEFT)){
                drawer.openDrawer(Gravity.LEFT)
            }
        }


//        closeDrawer.setOnClickListener {
//            if( drawer.isDrawerOpen(Gravity.LEFT)){
//                drawer.closeDrawer(Gravity.LEFT)
//            }
//        }

    }
}