package com.dicoding.picodiploma.kohinoka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.picodiploma.kohinoka.onboarding.TwoActivity

class SignInActivity : AppCompatActivity() {

    var signIn : Button ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signIn = findViewById(R.id.btn_sign)

       signIn ?.setOnClickListener {
            startActivity(Intent(this@SignInActivity, MainActivity::class.java))
        }
    }
}