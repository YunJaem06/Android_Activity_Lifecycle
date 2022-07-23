package com.example.android_activity_lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_activity_lifecycle.databinding.FragmentOrderBookmarkBinding

class OrderBookMarkFragment : Fragment(){

    lateinit var binding : FragmentOrderBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBookmarkBinding.inflate(inflater, container, false)

        return binding.root
    }
}