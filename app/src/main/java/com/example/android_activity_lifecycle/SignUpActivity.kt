package com.example.android_activity_lifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.android_activity_lifecycle.databinding.ActivityLoginBinding
import com.example.android_activity_lifecycle.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var sharedPreferences : SharedPreferences
    var AutoLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, "Signup onCreate", Toast.LENGTH_SHORT).show()

        binding.btnSignupSuccess.setOnClickListener {
            val edtId = binding.edtSignupId.text.toString()
            val edtPw = binding.edtSignupPassword.text.toString()
            run {
                UserInfoList.forEach {
                    if (edtId == it.userID && edtPw == it.userPW ) {
                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                        AutoLogin = true
                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        return@run
                    }
                }
                Toast.makeText(this, "다시 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Signup onStart",Toast.LENGTH_SHORT).show()
        val sp = getSharedPreferences("signup", MODE_PRIVATE)
        if(sp.getBoolean("AutoLogin", true)) {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", sp.getString("id", "ErrorId"))
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
    }

    // 데이터를 임시로 저장이 필요한 경우 사용
    override fun onPause() {
        super.onPause()
        val sp = getSharedPreferences("signup", MODE_PRIVATE)
        val editor = sp.edit()
        editor.putBoolean("AutoLogin", AutoLogin)
        if (AutoLogin) {
            editor.putString("id", binding.edtSignupId.text.toString())
            editor.putString("pw", binding.edtSignupPassword.text.toString())
        } else {
            editor.putString("id", "ErrorId")
            editor.putString("pw", "ErrorPw")
        }
        editor.apply()

        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show()
    }

    // onStop 생명주기는 액티비틱 화면에 보여지지 않을때 호출
    // 그래서 텍스트를 초기화 하기위해 작성.
    override fun onStop() {
        super.onStop()
        binding.edtSignupId.setText("")
        binding.edtSignupPassword.setText("")

        Toast.makeText(this,"Signup onStop",Toast.LENGTH_SHORT).show()
    }

    // 사용했던 자원들을 전부 정리.
    override fun onDestroy() {
        super.onDestroy()
        val sp = getSharedPreferences("signup", MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove("id").apply()
        editor.remove("pw").apply()

        Toast.makeText(this,"Signup onDestroy",Toast.LENGTH_SHORT).show()
    }
}