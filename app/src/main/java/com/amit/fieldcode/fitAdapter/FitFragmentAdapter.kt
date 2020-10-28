package com.amit.fieldcode.fitAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class FitFragmentAdapter(supportFragmentManager: FragmentManager) :
    FragmentStatePagerAdapter
        (supportFragmentManager) {

    val mFragmentList = ArrayList<Fragment>()
    val mFragmentTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitle.add(title)
    }

}
