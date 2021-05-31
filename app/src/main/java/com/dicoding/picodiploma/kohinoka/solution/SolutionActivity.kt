package com.dicoding.picodiploma.kohinoka.solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        solutionBinding.button.setOnClickListener {
            val db = Firebase.firestore

            val user = hashMapOf(
                "nama" to "Kenneth",
                "kategori" to "Wibu",
                "lahir" to 1815,
                "status" to "Jomblo"
            )

// Add a new document with a generated ID
            db.collection("Kenneth")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error adding document", e)
                }
        }
    }
}