package com.sematec.basic.pager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import kotlinx.android.synthetic.main.activity_my_view_pager.*
import kotlinx.android.synthetic.main.activity_my_view_pager.view.*

class MyViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_pager)


        // 5 fragments
        // 1 viewPager
        // fragment list created
        // adapter
        // assign adapter to ViewPager
        // add tab indicator library
        // add tab indicator widget top or bottom of ViewPager
        // getTitle of each fragment in Adapter
        // assign tab indicator to viewPager

        val fragments = listOf(
            MySimpleFragmentA(),
            MySimpleFragmentB(),
            MySimpleFragmentC(),
            MySimpleFragmentD(),
            MySimpleFragmentE(),
        )

        val adapter = MyViewPagerAdapter(supportFragmentManager, fragments)

        viewPager.adapter = adapter

        tabIndicator.setViewPager(viewPager)

    }
}