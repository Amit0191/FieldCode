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
import kotlinx.android.synthetic.main.fit_fragment_skilled.*
import kotlinx.android.synthetic.main.fit_item_skilled.view.*

class FitSkilledFragment : Fragment() {

    val mSkilledArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_skilled, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        val mSkilledAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_skilled,
            onBind = { view, item, position ->
                view.skilledImage.clipToOutline = true
                view.skilledImage.setImageResource(mSkilledArray[position].modelSkilledImage)
                view.skilledTitle.text = mSkilledArray[position].modelSkilledTitle
            },

            onViewClicked = { _, _, _ -> })

        skilledRecycler.adapter = mSkilledAdapter
        skilledRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mSkilledAdapter.addItems(addSkilledItem())

    }

    private fun addSkilledItem(): ArrayList<FitModel> {

        mSkilledArray.clear()

        val model1 = FitModel()
        model1.modelSkilledImage = R.drawable.fit_athlete3
        model1.modelSkilledTitle = "Cardio Exercise"
        mSkilledArray.add(model1)

        val model2 = FitModel()
        model2.modelSkilledImage = R.drawable.fit_body_weight
        model2.modelSkilledTitle = "Body Weight"
        mSkilledArray.add(model2)

        val model3 = FitModel()
        model3.modelSkilledImage = R.drawable.fit_athlete_user
        model3.modelSkilledTitle = "Flow Yoga"
        mSkilledArray.add(model3)

        val model4 = FitModel()
        model4.modelSkilledImage = R.drawable.fit_athlete
        model4.modelSkilledTitle = "Keep-fit Exercise"
        mSkilledArray.add(model4)

        val model5 = FitModel()
        model5.modelSkilledImage = R.drawable.fit_slide4
        model5.modelSkilledTitle = "Bulgarian Squat"
        mSkilledArray.add(model5)

        return mSkilledArray
    }
}
