package com.dicoding.picodiploma.kohinoka.scan

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.kohinoka.databinding.ActivityScanBinding

class ScanActivity : AppCompatActivity() {

    private lateinit var scanBinding: ActivityScanBinding
    private lateinit var scanViewModel: ScanViewModel
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scanBinding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(scanBinding.root)

        scanBinding.takePicture.setOnClickListener{
            dispatchTakePictureIntent()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE && data != null){
            scanBinding.tvImage.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }
}