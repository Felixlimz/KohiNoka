package com.dicoding.picodiploma.kohinoka.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.picodiploma.kohinoka.MainActivity
import com.dicoding.picodiploma.kohinoka.R

class ThreeActivity : AppCompatActivity() {

   var btnStart : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        btnStart = findViewById(R.id.btn_start)

        btnStart ?.setOnClickListener {
            startActivity(Intent(this@ThreeActivity, MainActivity::class.java))
        }
        }
    }
