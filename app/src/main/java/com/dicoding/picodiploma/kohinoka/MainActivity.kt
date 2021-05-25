package com.dicoding.picodiploma.kohinoka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.kohinoka.NokaPedia.DetailPediaActivity
import com.dicoding.picodiploma.kohinoka.NokaPedia.HomePediaActivity
import com.dicoding.picodiploma.kohinoka.NokaPedia.PediaFragment
import com.dicoding.picodiploma.kohinoka.databinding.ActivityMainBinding
import com.dicoding.picodiploma.kohinoka.scan.ScanActivity
import com.dicoding.picodiploma.kohinoka.video.VideoListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.scanProduct.setOnClickListener {
            val intent = Intent(this, ScanActivity::class.java)
            startActivity(intent)
        }

        mainBinding.inpirasiKita.setOnClickListener{
            val intent = Intent(this, VideoListActivity::class.java)
            startActivity(intent)
        }

        mainBinding.artikel.setOnClickListener {
            startActivity(Intent(this@MainActivity, HomePediaActivity::class.java))

        }
    }

}