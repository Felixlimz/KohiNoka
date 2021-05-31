package com.dicoding.picodiploma.kohinoka.solution

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.kohinoka.R
import com.dicoding.picodiploma.kohinoka.databinding.ActivitySolutionBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SolutionActivity : AppCompatActivity() {

    private lateinit var solutionBinding: ActivitySolutionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        solutionBinding = ActivitySolutionBinding.inflate(layoutInflater)
        setContentView(solutionBinding.root)

        val penyakit = intent.getStringExtra("EXTRA").toString()

        val db = Firebase.firestore

        val reference = db.collection("data_penyakit").document(penyakit)
        reference.get()
                .addOnSuccessListener {document ->
                    if(document != null){
                        Log.e("PRINT",document.data.toString())
                        solutionBinding.tvPenyakit.text = penyakit
                        solutionBinding.tvArtikel.text = document.data?.get("artikel").toString()
                        Glide.with(this)
                                .load(document.data?.get("poster").toString())
                                .into(solutionBinding.tvImage)

                        solutionBinding.button.visibility = View.VISIBLE
                        solutionBinding.button.setOnClickListener {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${document.data?.get("video")}"))
                            intent.setPackage("com.google.android.youtube")
                            startActivity(intent)
                        }
                    } else {
                        Log.e("ERROR", "NO DATA")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("SA", "get failed with ", exception)
                }
    }
}