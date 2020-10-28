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
import kotlinx.android.synthetic.main.fit_fragment_beginner.*
import kotlinx.android.synthetic.main.fit_item_beginner.view.*
import kotlinx.android.synthetic.main.fit_item_beginner.view.beginnerItemImage

class FitBeginnerFragment : Fragment() {

    val mBeginnerArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_beginner, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // beginnerImage.clipToOutline = true

        beginnerImage.setClipToOutline(true)


        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        val mBegineerAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_beginner,
            onBind = { view, _, position ->
                view.beginnerItemImage.setImageResource(mBeginnerArray[position].modelBeginnerImage)
                view.beginnerName.text = mBeginnerArray[position].modelBeginnerName
                view.beginnerItemImage.setClipToOutline(true)
            },

            onViewClicked = { _, _, _ -> })

        beginnerRecycler.adapter = mBegineerAdapter
        beginnerRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mBegineerAdapter.addItems(addBeginnerItem())

        beginnerRecycler.clipToPadding = false
        beginnerRecycler.setPadding(20, 0, 0, 0)

    }

    private fun addBeginnerItem(): ArrayList<FitModel> {

        val model1 = FitModel()
        model1.modelBeginnerImage = R.drawable.fit_flow_yoga
        model1.modelBeginnerName = "Flow Yoga"
        mBeginnerArray.add(model1)

        val model2 = FitModel()
        model2.modelBeginnerImage = R.drawable.fit_split_squat
        model2.modelBeginnerName = "Split Squat"
        mBeginnerArray.add(model2)

        val model3 = FitModel()
        model3.modelBeginnerImage = R.drawable.fit_flow_yoga
        model3.modelBeginnerName = "Flow Yoga"
        mBeginnerArray.add(model3)

        val model4 = FitModel()
        model4.modelBeginnerImage = R.drawable.fit_athlete
        model4.modelBeginnerName = "Split Squat"
        mBeginnerArray.add(model4)

        val model5 = FitModel()
        model5.modelBeginnerImage = R.drawable.fit_athlete3
        model5.modelBeginnerName = "Flow Yoga"
        mBeginnerArray.add(model5)

        return mBeginnerArray
    }

}
