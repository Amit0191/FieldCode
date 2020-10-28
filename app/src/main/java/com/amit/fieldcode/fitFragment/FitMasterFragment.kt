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
import kotlinx.android.synthetic.main.fit_fragment_master.*
import kotlinx.android.synthetic.main.fit_item_master_justforyou.view.*
import kotlinx.android.synthetic.main.fit_item_master_popular.view.*
import kotlinx.android.synthetic.main.fit_item_master_yoga.view.*

class FitMasterFragment : Fragment() {

    val mMasterPopularArray: ArrayList<FitModel> = ArrayList()
    val mMasterJustArray: ArrayList<FitModel> = ArrayList()
    val mMasterYogaArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_master, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        txtPopular.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitSearchFragment())?.commit()
        }

        // Popular adapter

        val mMasterPopularAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_master_popular,
            onBind = { popularView, item, popularPosition ->
                popularView.popularImage.setImageResource(mMasterPopularArray[popularPosition].modelPopularImage)
                popularView.popularTitle.text =
                    mMasterPopularArray[popularPosition].modelPopularTitle
            },
            onViewClicked = { _, _, _ ->
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frameLayout_Container, FitItemDescriptionFragment())?.commit()
            })

        masterPopularRecycler.adapter = mMasterPopularAdapter
        masterPopularRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mMasterPopularAdapter.addItems(addMaterPopularItems())

        masterPopularRecycler.clipToPadding = false
        masterPopularRecycler.setPadding(20, 0, 20, 0)

        //Just For you adapter

        val mMasterJustForAdapter =
            FitRecyclerViewGenericAdapter(R.layout.fit_item_master_justforyou,
                onBind = { justView, _, justPosition ->
                    justView.JustImage.setImageResource(mMasterJustArray[justPosition].modelJustImage)
                    justView.JustTitle.text =
                        mMasterJustArray[justPosition].modelJustTitle
                },
                onViewClicked = { view, item, position ->
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.frameLayout_Container, FitItemDescriptionFragment())
                        ?.commit()
                })

        masterJustForRecycler.adapter = mMasterJustForAdapter
        masterJustForRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mMasterJustForAdapter.addItems(mMasterJustItems())

        masterJustForRecycler.clipToPadding = false
        masterJustForRecycler.setPadding(20, 0, 20, 0)

        // Yoga master adapter

        val mMasterYogaAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_master_yoga,
            onBind = { yogaView, item, yogaPosition ->
                yogaView.yogaImage.setImageResource(mMasterYogaArray[yogaPosition].modelYogaImage)
                yogaView.yogaTitle.text =
                    mMasterYogaArray[yogaPosition].modelYogaTitle
            },
            onViewClicked = { _, _, _ -> })

        masterYogaRecycler.adapter = mMasterYogaAdapter
        masterYogaRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mMasterYogaAdapter.addItems(mMasterYogaItems())

        masterYogaRecycler.clipToPadding = false
        masterYogaRecycler.setPadding(20, 0, 20, 0)

    }

    private fun addMaterPopularItems(): ArrayList<FitModel> {

        mMasterPopularArray.clear()

        val model1 = FitModel()
        model1.modelPopularImage = R.drawable.fit_flow_yoga
        model1.modelPopularTitle = "Flow Yoga"
        mMasterPopularArray.add(model1)

        val model2 = FitModel()
        model2.modelPopularImage = R.drawable.fit_split_squat
        model2.modelPopularTitle = "Split Squat"
        mMasterPopularArray.add(model2)

        val model3 = FitModel()
        model3.modelPopularImage = R.drawable.fit_flow_yoga
        model3.modelPopularTitle = "Flow Yoga"
        mMasterPopularArray.add(model3)

        val model4 = FitModel()
        model4.modelPopularImage = R.drawable.fit_athlete
        model4.modelPopularTitle = "Split Squat"
        mMasterPopularArray.add(model4)

        val model5 = FitModel()
        model5.modelPopularImage = R.drawable.fit_athlete3
        model5.modelPopularTitle = "Flow Yoga"
        mMasterPopularArray.add(model5)

        return mMasterPopularArray
    }

    private fun mMasterJustItems(): ArrayList<FitModel> {

        mMasterJustArray.clear()

        val model1 = FitModel()
        model1.modelJustImage = R.drawable.fit_body_weight
        model1.modelJustTitle = "Body Weight"
        mMasterJustArray.add(model1)

        val model2 = FitModel()
        model2.modelJustImage = R.drawable.fit_split_squat
        model2.modelJustTitle = "Split Squat"
        mMasterJustArray.add(model2)

        val model3 = FitModel()
        model3.modelJustImage = R.drawable.fit_athlete3
        model3.modelJustTitle = "Bulgarian"
        mMasterJustArray.add(model3)

        val model4 = FitModel()
        model4.modelJustImage = R.drawable.fit_athlete
        model4.modelJustTitle = "Split Squat"
        mMasterJustArray.add(model4)

        val model5 = FitModel()
        model5.modelJustImage = R.drawable.fit_body_weight
        model5.modelJustTitle = "Body Weight"
        mMasterJustArray.add(model5)

        return mMasterJustArray
    }

    private fun mMasterYogaItems(): ArrayList<FitModel> {

        mMasterYogaArray.clear()

        val model1 = FitModel()
        model1.modelYogaImage = R.drawable.fit_athlete3
        model1.modelYogaTitle = "Body Weight"
        mMasterYogaArray.add(model1)

        val model2 = FitModel()
        model2.modelYogaImage = R.drawable.fit_athlete
        model2.modelYogaTitle = "Split Squat"
        mMasterYogaArray.add(model2)

        val model3 = FitModel()
        model3.modelYogaImage = R.drawable.fit_athlete3
        model3.modelYogaTitle = "Bulgarian"
        mMasterYogaArray.add(model3)

        val model4 = FitModel()
        model4.modelYogaImage = R.drawable.fit_athlete
        model4.modelYogaTitle = "Split Squat"
        mMasterYogaArray.add(model4)

        val model5 = FitModel()
        model5.modelYogaImage = R.drawable.fit_athlete3
        model5.modelYogaTitle = "Body Weight"
        mMasterYogaArray.add(model5)

        return mMasterYogaArray
    }
}
