package com.dicoding.picodiploma.kohinoka.NokaPedia

import androidx.lifecycle.ViewModel

class PediaViewModel : ViewModel() {

    fun getPedia() : List<DataPedia> = DummyPedia.generatePedia()
}