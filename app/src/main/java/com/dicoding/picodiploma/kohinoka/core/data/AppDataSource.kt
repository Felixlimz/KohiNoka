package com.dicoding.picodiploma.kohinoka.core.data

import androidx.lifecycle.LiveData
import com.dicoding.picodiploma.kohinoka.core.data.entity.ItemsItem

interface AppDataSource {
    fun getVideos(): LiveData<List<ItemsItem>>
}