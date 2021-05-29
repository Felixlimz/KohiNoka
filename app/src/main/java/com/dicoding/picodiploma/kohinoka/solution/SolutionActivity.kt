package com.dicoding.picodiploma.kohinoka.solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.kohinoka.R
import com.dicoding.picodiploma.kohinoka.databinding.ActivitySolutionBinding

class SolutionActivity : AppCompatActivity() {

    private lateinit var solutionBinding: ActivitySolutionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        solutionBinding = ActivitySolutionBinding.inflate(layoutInflater)
        setContentView(solutionBinding.root)
    }
}