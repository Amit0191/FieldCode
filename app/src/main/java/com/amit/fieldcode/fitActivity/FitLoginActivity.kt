package com.amit.fieldcode.fitActivity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.amit.fieldcode.R
import com.amit.fieldcode.fitAdapter.FitLoginViewPagerAdapter
import com.amit.fieldcode.fitUtils.FitBaseActivity
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_activity_login.*

class FitLoginActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_login)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        btnLogInFaceBook.click {
            startActivity(Intent(this, FitLoginBackActivity::class.java))
        }

        txtLogIn.click {
            startActivity(Intent(this, FitCreateWithEmailActivity::class.java))
        }

        txtCreateWithEmail.click {
            startActivity(Intent(this, FitCreateWithEmailActivity::class.java))
        }

        val mLoginImage = arrayOf(
            R.mipmap.fit_slide5,
            R.mipmap.fit_slide8,
            R.mipmap.fit_slide6,
            R.mipmap.fit_slide7
        )

        val mLoginViewPagerAdapter = FitLoginViewPagerAdapter(this, mLoginImage)
        vpLogin.adapter = mLoginViewPagerAdapter

        val mDotsCount = mLoginViewPagerAdapter.count

        val mDot = arrayOfNulls<ImageView>(mDotsCount)

        for (i in 0 until mDotsCount) {
            mDot[0]?.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.fit_active_dot
                )
            )
            mDot[i] = ImageView(this)
            mDot[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.fit_non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(10, 0, 10, 0)
            LogInDotIndicator.addView(mDot[i], params)
        }

        vpLogin.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until mDotsCount) {
                    mDot[i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.fit_non_active_dot
                        )
                    )
                }
                mDot[position]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.fit_active_dot
                    )
                )
            }
        })
    }

}
