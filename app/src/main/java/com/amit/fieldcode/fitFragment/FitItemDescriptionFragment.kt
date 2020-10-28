package com.amit.fieldcode.fitFragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager

import com.amit.fieldcode.R
import com.amit.fieldcode.fitAdapter.FitRecyclerViewGenericAdapter
import com.amit.fieldcode.fitModel.FitModel
import kotlinx.android.synthetic.main.fit_fragment_item_description.*
import kotlinx.android.synthetic.main.fit_item_schedule.view.*

class FitItemDescriptionFragment : Fragment() {

    private val mScheduleArray: ArrayList<FitModel> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_item_description, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        val mScheduleAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_schedule,
            onBind = { scheduleViewiew, item, schedulePosition ->
                scheduleViewiew.scheduleItemImage.clipToOutline = true
                scheduleViewiew.scheduleItemImage.setImageResource(mScheduleArray[schedulePosition].modelScheduleImage)
                scheduleViewiew.scheduleDay.text = mScheduleArray[schedulePosition].modelScheduleDay
                scheduleViewiew.scheduleName.text =
                    mScheduleArray[schedulePosition].modelScheduleName
            },
            onViewClicked = { _, _, _ -> })

        scheduleRecyclerview.adapter = mScheduleAdapter
        scheduleRecyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mScheduleAdapter.addItems(addScheduleItem())

        toolbar.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitCoursesFragment())?.commit()
        }
    }

    private fun addScheduleItem(): java.util.ArrayList<FitModel> {

        mScheduleArray.clear()

        val model1 = FitModel()
        model1.modelScheduleImage = R.drawable.fit_split_squat
        model1.modelScheduleDay = "DAY 01"
        model1.modelScheduleName = "Breath adjustment and warm-up"
        mScheduleArray.add(model1)

        val model2 = FitModel()
        model2.modelScheduleImage = R.drawable.fit_athlete2
        model2.modelScheduleDay = "DAY 02"
        model2.modelScheduleName = "Basic posture exercise"
        mScheduleArray.add(model2)

        val model3 = FitModel()
        model3.modelScheduleImage = R.drawable.fit_split_squat
        model3.modelScheduleDay = "DAY 03"
        model3.modelScheduleName = "Leg exercise"
        mScheduleArray.add(model3)

        val model4 = FitModel()
        model4.modelScheduleImage = R.drawable.fit_flow_yoga
        model4.modelScheduleDay = "DAY 04"
        model4.modelScheduleName = "Breath adjustment and warm-up"
        mScheduleArray.add(model4)

        val model5 = FitModel()
        model5.modelScheduleImage = R.drawable.fit_split_squat
        model5.modelScheduleDay = "DAY 05"
        model5.modelScheduleName = "Basic posture exercise"
        mScheduleArray.add(model5)

        return mScheduleArray
    }

}
