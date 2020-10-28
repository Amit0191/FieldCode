package com.amit.fieldcode.fitFragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager

import com.amit.fieldcode.R
import com.amit.fieldcode.fitActivity.FitNotificationActivity
import com.amit.fieldcode.fitAdapter.FitRecyclerViewGenericAdapter
import com.amit.fieldcode.fitAdapter.TrainingViewPagerAdapter
import com.amit.fieldcode.fitModel.FitModel
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_fragment_training.*
import kotlinx.android.synthetic.main.fit_item_training.view.*

class FitTrainingFragment : Fragment() {

    val mTrainingArray: ArrayList<FitModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? = inflater.inflate(R.layout.fit_fragment_training, container, false)

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        trainingImage.clipToOutline = true

        btnGetNow.click {
            val dialogBuilder = context?.let { it1 -> AlertDialog.Builder(it1) }
            val dialogLayoutInflater =
                layoutInflater.inflate(R.layout.fit_layout_dialog, null)
            dialogBuilder?.setView(dialogLayoutInflater)
            dialogBuilder?.setCancelable(true)
            val alert = dialogBuilder?.create()
            if (alert != null) {
                alert.window?.decorView?.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
            }
            alert?.show()
        }

        val mTrainingRecyclerViewGenericAdapter =
            FitRecyclerViewGenericAdapter(R.layout.fit_item_training,
                onBind = { view, item, position ->
                    view.tItemImage.clipToOutline = true
                    view.tItemImage.setImageResource(mTrainingArray[position].modelTrainingImage)
                    view.tItemTitle.text = mTrainingArray[position].modelTrainingTitle
                    view.tItemSubtitle.text = mTrainingArray[position].modelTrainingSubTitle
                },
                onViewClicked = { _, _, _ -> })

        trainingRecyclerview.adapter = mTrainingRecyclerViewGenericAdapter
        trainingRecyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mTrainingRecyclerViewGenericAdapter.addItems(addTrainingData())

        trainingRecyclerview.clipToPadding = false
        trainingRecyclerview.setPadding(20, 0, 20, 0)

        val mTrainingImage = arrayOf(
            R.mipmap.fit_slide6,
            R.mipmap.fit_slide8,
            R.mipmap.fit_slide5,
            R.mipmap.fit_slide7
        )

        val mTrainingViewPagerAdapter = TrainingViewPagerAdapter(context, mTrainingImage)
        trainingViewPager.adapter = mTrainingViewPagerAdapter

        activity?.edtTraining?.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitTrainingStatisticsFragment())?.commit()
        }

        Notification.click {
            startActivity(Intent(context, FitNotificationActivity::class.java))
        }

        val mDotsCount = mTrainingViewPagerAdapter.count

        val mDot = arrayOfNulls<ImageView>(mDotsCount)

        for (i in 0 until mDotsCount) {
            mDot[0]?.setImageDrawable(
                context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.fit_non_active_dot
                    )
                })
            mDot[i] = ImageView(context)
            mDot[i]?.setImageDrawable(
                context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.fit_active_dot_grey
                    )
                }
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(10, 0, 10, 0)
            dotTrainingIndicator.addView(mDot[i], params)
        }

        trainingViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until mDotsCount) {
                    mDot[i]?.setImageDrawable(
                        context?.let {
                            ContextCompat.getDrawable(
                                it,
                                R.drawable.fit_active_dot_grey
                            )
                        }
                    )
                }
                mDot[position]?.setImageDrawable(
                    context?.let {
                        ContextCompat.getDrawable(
                            it,
                            R.drawable.fit_non_active_dot
                        )
                    }
                )
            }
        })
    }


    private fun addTrainingData(): ArrayList<FitModel> {

        mTrainingArray.clear()

        val model1 = FitModel()
        model1.modelTrainingImage = R.drawable.fit_athlete
        model1.modelTrainingTitle = "Yoga Experts"
        model1.modelTrainingSubTitle = "Community"
        mTrainingArray.add(model1)

        val model2 = FitModel()
        model2.modelTrainingImage = R.drawable.fit_athlete3
        model2.modelTrainingTitle = "Legs and Abs"
        model2.modelTrainingSubTitle = "Gym Training"
        mTrainingArray.add(model2)

        val model3 = FitModel()
        model3.modelTrainingImage = R.drawable.fit_athlete
        model3.modelTrainingTitle = "Yoga Experts"
        model3.modelTrainingSubTitle = "Community"
        mTrainingArray.add(model3)

        val model4 = FitModel()
        model4.modelTrainingImage = R.drawable.fit_athlete3
        model4.modelTrainingTitle = "Yoga Experts"
        model4.modelTrainingSubTitle = "Community"
        mTrainingArray.add(model4)

        return mTrainingArray
    }
}
