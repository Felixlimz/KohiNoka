package com.dicoding.picodiploma.kohinoka.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.kohinoka.core.data.AppRepository
import com.dicoding.picodiploma.kohinoka.core.data.entity.ItemsItem

class VideoListViewModel(private val appRepository: AppRepository) : ViewModel() {

    fun getVideos(): LiveData<List<ItemsItem>> = appRepository.getVideos()
}