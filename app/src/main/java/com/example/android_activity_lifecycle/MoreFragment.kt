package com.example.android_activity_lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_activity_lifecycle.databinding.FragmentMoreBinding

class MoreFragment: Fragment() {

    lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMoreBinding.inflate(inflater, container, false)

        return binding.root
    }
}