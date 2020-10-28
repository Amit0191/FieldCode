package com.amit.fieldcode.fitFragment

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.amit.fieldcode.R
import com.amit.fieldcode.fitActivity.FitEditTrainingActivity
import com.amit.fieldcode.fitAdapter.FitRecyclerViewGenericAdapter
import com.amit.fieldcode.fitModel.FitModel
import kotlinx.android.synthetic.main.fit_fragment_training_statistics.*
import kotlinx.android.synthetic.main.fit_item_activity.view.*
import kotlinx.android.synthetic.main.fit_item_training_day.view.*
import me.ithebk.barchart.BarChart
import me.ithebk.barchart.BarChartModel


class FitTrainingStatisticsFragment : Fragment() {

    val mDayAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_training_day,
        onBind = { view, item, position ->
            view.trainingDay.text =
                mDayArray[position].modelTrainingDay
            if (mDayArray[position].modelDayValue) {
                view.trainingDay.setBackgroundResource(R.drawable.fit_layout_day_circle)
            } else {
                view.trainingDay.setBackgroundResource(R.drawable.fit_layout_day_else)
            }

        },
        onViewClicked = { view, item, position ->
            changeDrawable(position)
        })


    val mDayArray: ArrayList<FitModel> = ArrayList()
    val mActivityArray: ArrayList<FitModel> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_training_statistics, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        activity?.window?.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        val barChart: BarChart = activity?.findViewById(R.id.bar_chart_vertical) as BarChart
        barChart.barMaxValue = 100

        val barChartModel = BarChartModel()
        barChartModel.barValue = 40
        barChartModel.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartModel.barTag = null //You can set your own tag to bar model
        barChartModel.barText = "40"
        barChart.addBar(barChartModel)

        val barChartMode2 = BarChartModel()
        barChartMode2.barValue = 20
        barChartMode2.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode2.barTag = null //You can set your own tag to bar model
        barChartMode2.barText = "20"
        barChart.addBar(barChartMode2)

        val barChartMode3 = BarChartModel()
        barChartMode3.barValue = 80
        barChartMode3.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode3.barTag = null //You can set your own tag to bar model
        barChartMode3.barText = "80"
        barChart.addBar(barChartMode3)

        val barChartMode4 = BarChartModel()
        barChartMode4.barValue = 90
        barChartMode4.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode4.barTag = null //You can set your own tag to bar model
        barChartMode4.barText = "90"
        barChart.addBar(barChartMode4)

        val barChartMode5 = BarChartModel()
        barChartMode5.barValue = 100
        barChartMode5.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode5.barTag = null //You can set your own tag to bar model
        barChartMode5.barText = "100"
        barChart.addBar(barChartMode5)

        val barChartMode6 = BarChartModel()
        barChartMode6.barValue = 25
        barChartMode6.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode6.barTag = null //You can set your own tag to bar model
        barChartMode6.barText = "25"
        barChart.addBar(barChartMode6)

        val barChartMode7 = BarChartModel()
        barChartMode7.barValue = 30
        barChartMode7.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode7.barTag = null //You can set your own tag to bar model
        barChartMode7.barText = "30"
        barChart.addBar(barChartMode7)

        val barChartMode8 = BarChartModel()
        barChartMode8.barValue = 20
        barChartMode8.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode8.barTag = null //You can set your own tag to bar model
        barChartMode8.barText = "20"
        barChart.addBar(barChartMode8)

        val barChartMode9 = BarChartModel()
        barChartMode9.barValue = 80
        barChartMode9.barColor = resources.getColor(R.color.fit_colorPrimaryDark)
        barChartMode9.barTag = null //You can set your own tag to bar model
        barChartMode9.barText = "80"
        barChart.addBar(barChartMode9)

        val barChartMode10 = BarChartModel()
        barChartMode10.barValue = 90
        barChartMode10.barColor = resources.getColor(R.color.fit_colorPrimaryDark)
        barChartMode10.barTag = null //You can set your own tag to bar model
        barChartMode10.barText = "90"
        barChart.addBar(barChartMode10)

        val barChartMode11 = BarChartModel()
        barChartMode11.barValue = 100
        barChartMode11.barColor = resources.getColor(R.color.fit_colorPrimaryDark)
        barChartMode11.barTag = null //You can set your own tag to bar model
        barChartMode11.barText = "100"
        barChart.addBar(barChartMode11)

        val barChartMode12 = BarChartModel()
        barChartMode12.barValue = 70
        barChartMode12.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode12.barTag = null //You can set your own tag to bar model
        barChartMode12.barText = "70"
        barChart.addBar(barChartMode12)

        val barChartMode13 = BarChartModel()
        barChartMode13.barValue = 30
        barChartMode13.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode13.barTag = null //You can set your own tag to bar model
        barChartMode13.barText = "30"
        barChart.addBar(barChartMode13)

        val barChartMode14 = BarChartModel()
        barChartMode14.barValue = 35
        barChartMode14.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode14.barTag = null //You can set your own tag to bar model
        barChartMode14.barText = "35"
        barChart.addBar(barChartMode14)

        val barChartMode15 = BarChartModel()
        barChartMode15.barValue = 20
        barChartMode15.barColor = resources.getColor(R.color.fit_colorGrey)
        barChartMode15.barTag = null //You can set your own tag to bar model
        barChartMode15.barText = "20"
        barChart.addBar(barChartMode15)

        edittrainingStatistics.setOnClickListener {
            startActivity(Intent(context, FitEditTrainingActivity::class.java))
        }

        trainingDayRecycler.adapter = mDayAdapter
        trainingDayRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mDayAdapter.addItems(mDayItems())

        trainingDayRecycler.clipToPadding = false
        trainingDayRecycler.setPadding(20, 0, 0, 0)

        val mActivityAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_activity,
            onBind = { view, item, position ->
                view.txtActivityName.text = mActivityArray[position].modelActivityName
                view.txtActivityDistance.text = mActivityArray[position].modelActivityDistance
                view.txtActivityTime.text = mActivityArray[position].modelActivityDuration
            },
            onViewClicked = { view, item, position -> })

        activityRecycler.adapter = mActivityAdapter
        activityRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mActivityAdapter.addItems(addActivity())

        statisticsBack.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitTrainingFragment())?.commit()
        }
    }

    private fun changeDrawable(position: Int) {
        mDayArray.forEach { if (it.modelDayValue) it.modelDayValue = false }
        mDayArray[position].modelDayValue = true
        mDayAdapter.notifyItemChanged(position)
        mDayAdapter.notifyDataSetChanged()


    }

    private fun addActivity(): ArrayList<FitModel> {

        mActivityArray.clear()

        val model1 = FitModel()
        model1.modelActivityName = "Running"
        model1.modelActivityDistance = "12km"
        model1.modelActivityDuration = "45:20"
        mActivityArray.add(model1)

        val model2 = FitModel()
        model2.modelActivityName = "Walking"
        model2.modelActivityDistance = "2km"
        model2.modelActivityDuration = "15:20"
        mActivityArray.add(model2)

        val model3 = FitModel()
        model3.modelActivityName = "Cycling"
        model3.modelActivityDistance = "5km"
        model3.modelActivityDuration = "30:20"
        mActivityArray.add(model3)

        return mActivityArray
    }

    private fun mDayItems(): ArrayList<FitModel> {

        mDayArray.clear()

        val model1 = FitModel()
        model1.modelTrainingDay = "Su"
        mDayArray.add(model1)

        val model2 = FitModel()
        model2.modelTrainingDay = "Mo"
        mDayArray.add(model2)

        val model3 = FitModel()
        model3.modelTrainingDay = "Tu"
        mDayArray.add(model3)

        val model4 = FitModel()
        model4.modelTrainingDay = "We"
        mDayArray.add(model4)

        val model5 = FitModel()
        model5.modelTrainingDay = "Th"
        mDayArray.add(model5)

        val model6 = FitModel()
        model6.modelTrainingDay = "Fr"
        mDayArray.add(model6)

        val model7 = FitModel()
        model7.modelTrainingDay = "Sa"
        mDayArray.add(model7)

        return mDayArray

    }

}
