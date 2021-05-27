package com.dicoding.picodiploma.kohinoka.scan

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.kohinoka.databinding.ActivityScanBinding
import com.dicoding.picodiploma.kohinoka.imageprocessor.Classify

class ScanActivity : AppCompatActivity() {

    private lateinit var scanBinding: ActivityScanBinding
    private lateinit var scanViewModel: ScanViewModel
    val REQUEST_IMAGE_CAPTURE = 1
    private val mInputSize = 299
    private val mModelPath = "converted_model.tflite"
    private val mLabelPath = "label.txt"

    private lateinit var classifier: Classify

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scanBinding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(scanBinding.root)

        classifier = Classify(assets, mModelPath, mLabelPath, mInputSize)

        scanBinding.takePicture.setOnClickListener{
            dispatchTakePictureIntent()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE && data != null){
            val image = data.extras?.get("data") as Bitmap
            scanBinding.tvImage.setImageBitmap(image)
            val result = classifier.recognizeImage(image)
            runOnUiThread { Toast.makeText(this, result.get(0).title, Toast.LENGTH_SHORT).show() }
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