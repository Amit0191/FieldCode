package com.amit.fieldcode.fitFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.amit.fieldcode.R
import com.amit.fieldcode.fitAdapter.FitViewPagerTabAdapter
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_fragment_courses.*

class FitCoursesFragment : Fragment() {

    val fitMasterFragment = FitMasterFragment()
    val fitSkilledFragment = FitSkilledFragment()
    val fitBeginnerFragment = FitBeginnerFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? = inflater.inflate(R.layout.fit_fragment_courses, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val supportFragmentManager = activity?.supportFragmentManager
        val fragmentPagerAdapter = FitViewPagerTabAdapter(childFragmentManager)

        fragmentPagerAdapter.addFragment(FitMasterFragment(), "Master")
        fragmentPagerAdapter.addFragment(FitSkilledFragment(), "Skilled")
        fragmentPagerAdapter.addFragment(FitBeginnerFragment(), "Beginner")

        coursesViewPager.adapter = fragmentPagerAdapter
        coursesTabLayout.setupWithViewPager(coursesViewPager)

        editCourses.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitSearchFragment())?.commit()
        }
    }

}
