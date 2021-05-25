package com.dicoding.picodiploma.kohinoka.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dicoding.picodiploma.kohinoka.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var handler = Handler()
        handler.postDelayed({
           var intent = Intent(this@SplashScreenActivity, OneActivity::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}