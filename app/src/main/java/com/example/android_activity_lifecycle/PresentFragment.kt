package com.example.android_activity_lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_activity_lifecycle.databinding.FragmentPresentBinding

class PresentFragment: Fragment() {

    lateinit var binding: FragmentPresentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPresentBinding.inflate(inflater, container, false)

        return binding.root
    }
}