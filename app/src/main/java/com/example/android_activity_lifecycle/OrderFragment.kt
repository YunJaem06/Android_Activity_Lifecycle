package com.example.android_activity_lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_activity_lifecycle.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment: Fragment() {

    lateinit var binding: FragmentOrderBinding
    private val information = arrayListOf("리스트로 선택", "지도로 선택", "즐겨찾기")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOrderBinding.inflate(inflater, container, false)

        val orderAdapter = OrderVpAdapter(this)
        binding.vpOrderContent.adapter = orderAdapter
        TabLayoutMediator(binding.tlOrderContent, binding.vpOrderContent) {
            tab,position ->
            tab.text = information[position]
        }.attach()

        return binding.root
    }
}