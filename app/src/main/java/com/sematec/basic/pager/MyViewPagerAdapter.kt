package com.sematec.basic.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyViewPagerAdapter(fm: FragmentManager, val fragments: List<Fragment>) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "FragmentA"
            1 -> "FragmentB"
            2 -> "FragmentC"
            3 -> "FragmentD"
            4 -> "FragmentE"
            else -> ""
        }
    }
}