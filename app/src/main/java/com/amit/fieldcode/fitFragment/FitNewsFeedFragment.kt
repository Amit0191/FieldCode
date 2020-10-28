package com.amit.fieldcode.fitFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.amit.fieldcode.R

class FitNewsFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):

            View? = inflater.inflate(R.layout.fit_fragment_news_feed, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}
