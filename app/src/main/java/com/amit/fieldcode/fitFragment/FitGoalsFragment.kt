package com.amit.fieldcode.fitFragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager

import com.amit.fieldcode.R
import com.amit.fieldcode.fitAdapter.FitRecyclerViewGenericAdapter
import com.amit.fieldcode.fitModel.FitModel
import kotlinx.android.synthetic.main.fit_fragment_goals.*
import kotlinx.android.synthetic.main.fit_item_goal.view.*
import me.ithebk.barchart.BarChart
import me.ithebk.barchart.BarChartModel

class FitGoalsFragment : Fragment() {

    val mGoalArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_goals, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        activity?.window?.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        val mGoalAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_goal,
            onBind = { view, _, position ->
                view.goalName.text = mGoalArray[position].modelGoalName
                view.goalTime.text = mGoalArray[position].modelGoalTime
                view.goalDistance.text = mGoalArray[position].modelGoalDistance
            },
            onViewClicked = { _, _, _ -> })

        goalRecyclerview.adapter = mGoalAdapter
        goalRecyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mGoalAdapter.addItems(addGoalItem())

        val barChart: BarChart = activity?.findViewById(R.id.goal_bar_chart_vertical) as BarChart
        barChart.setBarMaxValue(100)

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

    }

    private fun addGoalItem(): java.util.ArrayList<FitModel> {

        mGoalArray.clear()

        val model1 = FitModel()
        model1.modelGoalName = "Today"
        model1.modelGoalTime = "+10m"
        model1.modelGoalDistance = "2.29km"
        mGoalArray.add(model1)

        val model2 = FitModel()
        model2.modelGoalName = "Yesterday"
        model2.modelGoalTime = "+23m"
        model2.modelGoalDistance = "2.29km"
        mGoalArray.add(model2)

        val model3 = FitModel()
        model3.modelGoalName = "2 day ago"
        model3.modelGoalTime = "+23m"
        model3.modelGoalDistance = "2.29km"
        mGoalArray.add(model3)

        val model4 = FitModel()
        model4.modelGoalName = "3 day ago"
        model4.modelGoalTime = "+23m"
        model4.modelGoalDistance = "2.29km"
        mGoalArray.add(model4)

        return mGoalArray
    }

}
