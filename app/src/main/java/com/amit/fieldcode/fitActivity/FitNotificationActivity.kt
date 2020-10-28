package com.amit.fieldcode.fitActivity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.FitBaseActivity
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_activity_notification.*

class FitNotificationActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_notification)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        notificationBack.click {
            startActivity(
                Intent(
                    this,
                    FitHomeActivity::class.java
                )
            )
        }

        notificationSwitch2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                startActivity(
                    Intent(
                        this,
                        FitFriendNearByActivity::class.java
                    )
                )
            }
        }

    }
}
