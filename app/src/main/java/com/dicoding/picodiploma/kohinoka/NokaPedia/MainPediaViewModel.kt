package com.dicoding.picodiploma.kohinoka.NokaPedia

import androidx.lifecycle.ViewModel

class MainPediaViewModel : ViewModel() {

    private lateinit var idContent : String
    fun setData(programId : String){
        this.idContent = programId
    }

    fun getPedia() : DataPedia{
        lateinit var pedia : DataPedia
        val dataPedia = DummyPedia.generatePedia()
        for (pediaa in dataPedia){
            if (pediaa.contentId == idContent){
                pedia = pediaa
            }
        }
        return pedia
    }
}