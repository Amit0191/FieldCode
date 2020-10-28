package com.amit.fieldcode.fitActivity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.amit.fieldcode.R
import com.amit.fieldcode.fitFragment.*
import com.amit.fieldcode.fitUtils.FitBaseActivity
import kotlinx.android.synthetic.main.fit_activity_home.*

class FitHomeActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_home)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        val mFitTrainingFragment = FitTrainingFragment()
        val mFitGoalsFragment = FitGoalsFragment()
        val mFitCoursesFragment = FitCoursesFragment()
        val mFitNewsFeedFragment = FitNewsFeedFragment()
        val mFitProfileFragment = FitProfileFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_Container, mFitTrainingFragment).commit()
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            return@setOnNavigationItemSelectedListener when (menuItem.itemId) {

                R.id.menuTraining -> {
                    loadFragment(mFitTrainingFragment)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.menuGoals -> {
                    loadFragment(mFitGoalsFragment)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.menuCourse -> {
                    loadFragment(mFitCoursesFragment)
                    return@setOnNavigationItemSelectedListener true
                }

//                R.id.menuNewsFeed -> {
//                    loadFragment(mFitNewsFeedFragment)
//                    return@setOnNavigationItemSelectedListener true
//                }

                R.id.menuProfile -> {
                    loadFragment(mFitProfileFragment)
                    return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout_Container, fragment)
        transaction.commit()
    }
}
