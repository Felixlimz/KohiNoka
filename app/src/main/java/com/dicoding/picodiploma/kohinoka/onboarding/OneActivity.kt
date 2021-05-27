package com.dicoding.picodiploma.kohinoka.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.picodiploma.kohinoka.MainActivity
import com.dicoding.picodiploma.kohinoka.R

class OneActivity : AppCompatActivity() {

    var btnNext : Button ? = null
    var btnSkip : Button ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        btnNext = findViewById(R.id.btn_next)
        btnSkip = findViewById(R.id.btn_skip)

        btnNext ?.setOnClickListener {
            startActivity(Intent(this@OneActivity, TwoActivity::class.java))
        }
        btnSkip?.setOnClickListener {
          var intent = Intent(this@OneActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}