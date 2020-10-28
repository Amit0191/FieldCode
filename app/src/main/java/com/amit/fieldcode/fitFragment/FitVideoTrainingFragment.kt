package com.amit.fieldcode.fitFragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi

import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_fragment_video_training.*

class FitVideoTrainingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_video_training, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.decorView?.systemUiVisibility = flags

        videoBackImage.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitProfileFragment())?.commit()
        }
    }


}
