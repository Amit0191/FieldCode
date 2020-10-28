package com.amit.fieldcode.fitAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.amit.fieldcode.R
import kotlinx.android.synthetic.main.fit_layout_training_viewpager.view.*

class TrainingViewPagerAdapter(val context: Context?, var mTrainingImage: Array<Int>) :
    PagerAdapter() {

    private var mInflater: LayoutInflater? = null
    private var mTrainingName = context?.resources?.getStringArray(R.array.fit_homeHeading)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount() = mTrainingImage.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        if (context != null) {
            mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        val view = mInflater!!.inflate(R.layout.fit_layout_training_viewpager, null)

        view.trainingVpImage.setImageResource(mTrainingImage[position])
        view.trainingVpHeading.text = mTrainingName?.get(position)

        val mViewPager = container as ViewPager
        mViewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val mViewPager = container as ViewPager
        val mView = `object` as View
        mViewPager.removeView(mView)
    }

}
