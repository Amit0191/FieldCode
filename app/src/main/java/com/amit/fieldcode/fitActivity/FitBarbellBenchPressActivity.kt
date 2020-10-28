package com.amit.fieldcode.fitActivity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.FitBaseActivity
import com.amit.fieldcode.fitUtils.FitCircularSeekBar
import kotlinx.android.synthetic.main.fit_activity_barbell_bench_press.*
import me.tankery.lib.circularseekbar.CircularSeekBar


class FitBarbellBenchPressActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_barbell_bench_press)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        seekBar.setOnSeekBarChangeListener(object : CircularSeekBar.OnCircularSeekBarChangeListener,
            FitCircularSeekBar.OnCircularSeekBarChangeListener {

            override fun onProgressChanged(
                circularSeekBar: CircularSeekBar,
                progress: Float,
                fromUser: Boolean
            ) {

            }

            override fun onStopTrackingTouch(seekBar: CircularSeekBar) {

            }

            override fun onStartTrackingTouch(seekBar: CircularSeekBar) {

            }


            override fun onProgressChanged(
                circularSeekBar: FitCircularSeekBar?,
                progress: Float,
                fromUser: Boolean
            ) {

            }

            override fun onStartTrackingTouch(seekBar: FitCircularSeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: FitCircularSeekBar?) {

            }
        })
    }
}
