package com.example.android_activity_lifecycle

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OrderVpAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OrderListFragment()
            1 -> OrderMapFragment()
            else -> OrderBookMarkFragment()
        }
    }
}