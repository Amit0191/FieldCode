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
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_fragment_teacher_details.*
import kotlinx.android.synthetic.main.fit_item_teacher.view.*

class FitTeacherDetailsFragment : Fragment() {

    var mTrainerArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_teacher_details, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        trainerBack.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitSearchFragment())?.commit()
        }
        val mTeacherAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_teacher,
            onBind = { View, item, schedulePosition ->
                View.teacheImage.clipToOutline = true
                View.teacheImage.setImageResource(mTrainerArray[schedulePosition].modelTrainerImage)
                View.teacherTitle.text = mTrainerArray[schedulePosition].modelTrainerName
            },
            onViewClicked = { _, _, _ -> })

        trainerRecycler.adapter = mTeacherAdapter
        trainerRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mTeacherAdapter.addItems(addTrainer())

        trainerRecycler.clipToPadding = false
        trainerRecycler.setPadding(20, 0, 20, 0)

        //  onBackPressed()
    }

    private fun onBackPressed() {

        activity?.supportFragmentManager?.popBackStack()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameLayout_Container, FitSearchFragment())?.commit()

    }

    private fun addTrainer(): java.util.ArrayList<FitModel> {

        mTrainerArray.clear()

        val model1 = FitModel()
        model1.modelTrainerImage = R.drawable.fit_flow_yoga
        model1.modelTrainerName = "Flow Yoga"
        mTrainerArray.add(model1)

        val model2 = FitModel()
        model2.modelTrainerImage = R.drawable.fit_split_squat
        model2.modelTrainerName = "Split Squat"
        mTrainerArray.add(model2)

        val model3 = FitModel()
        model3.modelTrainerImage = R.drawable.fit_flow_yoga
        model3.modelTrainerName = "Flow Yoga"
        mTrainerArray.add(model3)

        val model4 = FitModel()
        model4.modelTrainerImage = R.drawable.fit_athlete
        model4.modelTrainerName = "Split Squat"
        mTrainerArray.add(model4)

        val model5 = FitModel()
        model5.modelTrainerImage = R.drawable.fit_athlete3
        model5.modelTrainerName = "Flow Yoga"
        mTrainerArray.add(model5)


        return mTrainerArray
    }

}
