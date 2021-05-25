package com.dicoding.picodiploma.kohinoka.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.kohinoka.ViewModelFactory
import com.dicoding.picodiploma.kohinoka.databinding.ActivityVideoListBinding

class VideoListActivity : AppCompatActivity() {

    private lateinit var videoListBinding: ActivityVideoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        videoListBinding = ActivityVideoListBinding.inflate(layoutInflater)
        setContentView(videoListBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        val videoViewModel = ViewModelProvider(this,factory)[VideoListViewModel::class.java]

        val recyclerAdapter = VideoAdapter()

        videoListBinding.progressBar.visibility = View.VISIBLE
        videoViewModel.getVideos().observe(this, {
            videoListBinding.progressBar.visibility = View.GONE
            recyclerAdapter.setVideos(it)
            with(videoListBinding.rvTourism){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = recyclerAdapter
            }
        })
    }
}