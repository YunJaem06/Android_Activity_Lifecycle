package com.example.android_activity_lifecycle

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_activity_lifecycle.databinding.ActivityLogoutBinding

class LogoutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLogoutBinding
    private lateinit var sharedPreferences : SharedPreferences
    var loginCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clLogoutBtn.setOnClickListener {
            loginCheck = true
            Toast.makeText(this, "로그아웃 완료", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Logout onStop", Toast.LENGTH_SHORT).show()

        if (loginCheck) {
            val sp = getSharedPreferences("signup", MODE_PRIVATE)
            val editor = sp.edit()
            editor.putBoolean("AutoLogin", false)
            editor.putString("userName", "userName Error")
            editor.apply()
        }
    }
    // 사용했던 자원들을 전부 정리.
    override fun onDestroy() {
        super.onDestroy()
        val sp = getSharedPreferences("signup", MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove("id").apply()
        editor.remove("pw").apply()

        Toast.makeText(this,"Logout onDestroy",Toast.LENGTH_SHORT).show()
    }
}