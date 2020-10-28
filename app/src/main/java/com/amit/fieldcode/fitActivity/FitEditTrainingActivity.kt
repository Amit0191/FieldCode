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
import kotlinx.android.synthetic.main.fit_activity_edit_training.*

class FitEditTrainingActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_edit_training)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        btnNext.click {
            startActivity(Intent(this, FitSaveTrainingActivity::class.java))
        }

        cancel.click {
            startActivity(Intent(this, FitHomeActivity::class.java))
        }

//        var decoratorList: MutableList<CalendarCellDecorator?>? = calendarView.getDecorators()
//        if (decoratorList == null) {
//            decoratorList = ArrayList()
//        }
//        decoratorList.add(AppCalendarDecorator())
//        calendarView.setDecorators(decoratorList)
    }
}
