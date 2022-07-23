package com.example.android_activity_lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.android_activity_lifecycle.databinding.FragmentOrderMapBinding

class OrderMapFragment : Fragment(){

    lateinit var binding : FragmentOrderMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderMapBinding.inflate(inflater, container, false)

        return binding.root
    }
}