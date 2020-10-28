package com.amit.fieldcode.fitFragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi

import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_fragment_profile.*

class FitProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fit_fragment_profile, container, false)

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        activity?.window?.statusBarColor = android.R.color.transparent

        profileVideo.click {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.frameLayout_Container, FitVideoTrainingFragment())?.commit()
        }
    }
}
