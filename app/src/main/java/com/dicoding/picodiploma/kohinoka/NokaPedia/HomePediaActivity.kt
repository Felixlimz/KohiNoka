package com.dicoding.picodiploma.kohinoka.NokaPedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.kohinoka.R
import com.dicoding.picodiploma.kohinoka.databinding.ActivityHomePediaBinding

class HomePediaActivity : AppCompatActivity() {

    private lateinit var connectBinding : ActivityHomePediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectBinding = ActivityHomePediaBinding.inflate(layoutInflater)
        setContentView(connectBinding.root)
        pager()
    }

    private fun pager() {
        val pagerada = PagerAdapter(this, supportFragmentManager)
        connectBinding.viewPager.adapter = pagerada
       connectBinding.tabLayout.setupWithViewPager(connectBinding.viewPager)
        supportActionBar?.elevation = 0f
    }
}