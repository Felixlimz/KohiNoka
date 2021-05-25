package com.dicoding.picodiploma.kohinoka.core.data

import androidx.lifecycle.LiveData
import com.dicoding.picodiploma.kohinoka.core.data.entity.ItemsItem

class AppRepository private constructor(private val remoteData: RemoteDataSource) : AppDataSource{

    companion object{
        @Volatile
        private var instance: AppRepository? = null

        fun getInstance(remoteData: RemoteDataSource) : AppRepository =
            instance ?: synchronized(this){
                instance ?: AppRepository(remoteData).apply { instance = this }
            }
    }

    override fun getVideos(): LiveData<List<ItemsItem>> {
        val videoList = remoteData.getVideos()
        return videoList
    }
}