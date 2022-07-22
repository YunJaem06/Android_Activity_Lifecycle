package com.example.android_activity_lifecycle

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        binding.tvMoreSignSetting.setOnClickListener {
                val intent = Intent(context, LogoutActivity::class.java)
                startActivity(intent)
        }

        return binding.root
    }

}