package com.dicoding.picodiploma.kohinoka.NokaPedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.kohinoka.R
import com.dicoding.picodiploma.kohinoka.databinding.ActivityDetailPediaBinding
import com.google.android.material.snackbar.Snackbar

class DetailDuaPediaActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_Data"
    }

    private lateinit var connectBinding : ActivityDetailPediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectBinding = ActivityDetailPediaBinding.inflate(layoutInflater)
        setContentView(connectBinding.root)
        detailPedia()
    }

    private fun detailPedia(){
        val view = ViewModelProvider(this)[MainPediaViewModel::class.java]
        val pediaDetail = intent.getParcelableExtra<DataPedia>(EXTRA_DATA) as DataPedia

        if (pediaDetail != null){
            val idPedia = pediaDetail.contentId
            connectBinding.MyProgressBar.visibility = View.GONE
            view.setData(idPedia)
            val pediaData = view.getPedia()
            connectBinding.title.text = pediaDetail.title
            connectBinding.tvDescription.text = pediaDetail.description
            connectBinding.ivFoto.setImageResource(pediaDetail.image)

            if (pediaData == null){
                Snackbar.make(connectBinding.layoutConstraint, "Data Not Found", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}