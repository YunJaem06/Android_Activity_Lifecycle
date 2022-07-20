package com.example.android_activity_lifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.android_activity_lifecycle.databinding.ActivityLoginBinding
import com.example.android_activity_lifecycle.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSignupSuccess.setOnClickListener {
            val edtId = binding.edtSignupId.text.toString()
            val edtPw = binding.edtSignupPassword.text.toString()

            if(edtId!!.length < 3) {
                Toast.makeText(this, "아이디(3글자이상)를 입력해주세요", Toast.LENGTH_SHORT).show()

            } else {
                writeSharePreference("id", edtId)
                writeSharePreference("pw", edtPw)
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun writeSharePreference(key: String, value: String){
        val sp = getSharedPreferences("signup", MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        binding.edtSignupId.setText("")
        binding.edtSignupPassword.setText("")
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        val sp = getSharedPreferences("signup", MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove("id").apply()
        editor.remove("pw").apply()
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
    }
}