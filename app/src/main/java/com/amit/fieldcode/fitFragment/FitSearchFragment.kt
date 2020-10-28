package com.amit.fieldcode.fitFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.amit.fieldcode.R
import com.amit.fieldcode.fitAdapter.FitRecyclerViewGenericAdapter
import com.amit.fieldcode.fitModel.FitModel
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_fragment_search.*
import kotlinx.android.synthetic.main.fit_item_search_popular.view.*
import kotlinx.android.synthetic.main.fit_item_search_teacher.view.*
import kotlinx.android.synthetic.main.fit_item_search_teacher.view.teacherItemImage

class FitSearchFragment : Fragment() {

    val mSearchPopularArray: ArrayList<FitModel> = ArrayList()
    val mSearchTeacherArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        searchBackImage.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitCoursesFragment())?.commit()
        }

        val mSearchPopularAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_search_popular,
            onBind = { searchView, item, searchPosition ->
                searchView.searchItemImage.clipToOutline = true
                searchView.searchItemImage.setImageResource(mSearchPopularArray[searchPosition].modelSearchImage)
                searchView.searchItemName.text =
                    mSearchPopularArray[searchPosition].modelSearchName
            },
            onViewClicked = { _, _, _ ->
//                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frameLayout_Container,FitSearchFragment())?.commit()
            })

        searchPopularRecycler.adapter = mSearchPopularAdapter
        searchPopularRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mSearchPopularAdapter.addItems(addSearchPopularItems())

        searchPopularRecycler.clipToPadding = false
        searchPopularRecycler.setPadding(20, 0, 20, 0)

        //search Teacher recycler

        val mSearchTeacherAdapter = FitRecyclerViewGenericAdapter(R.layout.fit_item_search_teacher,
            onBind = { teacherView, item, teacherPosition ->
                teacherView.teacherItemImage.setImageResource(mSearchTeacherArray[teacherPosition].modelTeacherImage)
                teacherView.teacherItemName.text =
                    mSearchTeacherArray[teacherPosition].modelTeacherName
                teacherView.teacherType.text = mSearchTeacherArray[teacherPosition].modelTeacherType
                teacherView.teacherItemFollower.text =
                    mSearchTeacherArray[teacherPosition].modelTeacherFollower
            },
            onViewClicked = { _, _, _ ->
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frameLayout_Container, FitTeacherDetailsFragment())?.commit()
            })

        searchTeacherRecycler.adapter = mSearchTeacherAdapter
        searchTeacherRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mSearchTeacherAdapter.addItems(addSearchTeacherItems())

        searchTeacherRecycler.clipToPadding = false
        searchTeacherRecycler.setPadding(30, 0, 0, 0)
    }

    private fun addSearchTeacherItems(): java.util.ArrayList<FitModel> {

        mSearchTeacherArray.clear()

        val model1 = FitModel()
        model1.modelTeacherName = "Miranda John"
        model1.modelTeacherImage = R.drawable.fit_flow_yoga
        model1.modelTeacherType = "Hot! Yoga Teacher"
        model1.modelTeacherFollower = resources.getString(R.string.fit_1_2k_followers)
        mSearchTeacherArray.add(model1)

        val model2 = FitModel()
        model2.modelTeacherName = "Michael Carl"
        model2.modelTeacherImage = R.drawable.fit_split_squat
        model2.modelTeacherType = "Running Coach"
        model2.modelTeacherFollower = resources.getString(R.string.fit_100_followers)
        mSearchTeacherArray.add(model2)

        val model3 = FitModel()
        model3.modelTeacherName = "Kate Lewis"
        model3.modelTeacherImage = R.drawable.fit_flow_yoga
        model3.modelTeacherType = "Hot! Yoga Teacher"
        model3.modelTeacherFollower = resources.getString(R.string.fit_348_followers)
        mSearchTeacherArray.add(model3)

        val model4 = FitModel()
        model4.modelTeacherName = "Kelly Wong   "
        model4.modelTeacherImage = R.drawable.fit_athlete
        model4.modelTeacherType = "Yoga Master"
        model4.modelTeacherFollower = resources.getString(R.string.fit_30k_followers)
        mSearchTeacherArray.add(model4)

        val model5 = FitModel()
        model5.modelTeacherName = "miranda john"
        model5.modelTeacherImage = R.drawable.fit_athlete3
        model5.modelTeacherFollower = resources.getString(R.string.fit_2_2k_followers)
        model5.modelTeacherType = "Running Coach"
        mSearchTeacherArray.add(model5)

        return mSearchTeacherArray
    }

    private fun addSearchPopularItems(): java.util.ArrayList<FitModel> {

        mSearchPopularArray.clear()

        val model1 = FitModel()
        model1.modelSearchImage = R.drawable.fit_flow_yoga
        model1.modelSearchName = "Flow Yoga"
        mSearchPopularArray.add(model1)

        val model2 = FitModel()
        model2.modelSearchImage = R.drawable.fit_split_squat
        model2.modelSearchName = "Split Squat"
        mSearchPopularArray.add(model2)

        val model3 = FitModel()
        model3.modelSearchImage = R.drawable.fit_flow_yoga
        model3.modelSearchName = "Flow Yoga"
        mSearchPopularArray.add(model3)

        val model4 = FitModel()
        model4.modelSearchImage = R.drawable.fit_athlete
        model4.modelSearchName = "Split Squat"
        mSearchPopularArray.add(model4)

        val model5 = FitModel()
        model5.modelSearchImage = R.drawable.fit_athlete3
        model5.modelSearchName = "Flow Yoga"
        mSearchPopularArray.add(model5)

        return mSearchPopularArray
    }

}
