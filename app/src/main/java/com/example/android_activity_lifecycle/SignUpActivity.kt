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
                        intent.putExtra("userName", it.userName)
                        startActivity(intent)
                        finish()
                        return@run
                    }
                }
                Toast.makeText(this, "다시 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 자동로그인 auto가 true인것을 확인하고 onStart가 나오면 바로 화면전환
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


    // 그래서 텍스트를 초기화 하기위해 작성.
    override fun onRestart() {
        super.onRestart()
        binding.edtSignupId.setText("")
        binding.edtSignupPassword.setText("")

        Toast.makeText(this,"Signup onRestart",Toast.LENGTH_SHORT).show()
    }

    // 데이터를 임시로 저장이 필요한 경우 사용
    // 한번로그인을 하면 자동로그인을 할수 있게 하기 위해서 사용하였음
    // onPause가 되면 auto가 true인것을 확인하고 미리 작성
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

        Toast.makeText(this,"Signup onPause",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Signup onStop",Toast.LENGTH_SHORT).show()
    }
}