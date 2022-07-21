package com.example.android_activity_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android_activity_lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.fl_main_layout, HomeFragment()).commit()

        val data = intent.getStringExtra("id")
        val bundle = Bundle()
        bundle.putString("id", data)
        val moreFragment = MoreFragment()
        moreFragment.arguments = bundle

        binding.navigationMain.setOnNavigationItemSelectedListener {
            replaceFragment(
                when(it.itemId) {
                    R.id.navigation_home -> HomeFragment()
                    R.id.navigation_pay -> PayFragment()
                    R.id.navigation_order -> OrderFragment()
                    R.id.navigation_present -> PresentFragment()
                    else -> MoreFragment()
                }
            )
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fl_main_layout, fragment).commit()
    }

}