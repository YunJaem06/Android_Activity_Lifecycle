package com.example.android_activity_lifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
                binding.btnSignupSuccess.isEnabled = false

            } else {
                writeSharePreference("id", edtId)
                writeSharePreference("pw", edtPw)
                binding.btnSignupSuccess.isEnabled = true

                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
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
        Toast.makeText(this,"onDestory",Toast.LENGTH_SHORT).show()
    }
}