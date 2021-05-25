package com.dicoding.picodiploma.kohinoka.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dicoding.picodiploma.kohinoka.R
import com.dicoding.picodiploma.kohinoka.SignInActivity

class TwoActivity : AppCompatActivity() {

    var btnNext : Button? = null
    var btnSkip : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        btnNext = findViewById(R.id.btn_next)
        btnSkip = findViewById(R.id.btn_skip)

        btnNext ?.setOnClickListener {
            startActivity(Intent(this@TwoActivity, ThreeActivity::class.java))
        }
        btnSkip?.setOnClickListener {
            var intent = Intent(this@TwoActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}