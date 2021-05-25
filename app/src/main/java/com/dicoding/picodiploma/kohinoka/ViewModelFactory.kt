package com.dicoding.picodiploma.kohinoka

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.kohinoka.core.data.AppRepository
import com.dicoding.picodiploma.kohinoka.core.di.Injection
import com.dicoding.picodiploma.kohinoka.video.VideoListViewModel

class ViewModelFactory private constructor(private val mDataRepository: AppRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(VideoListViewModel::class.java) -> {
                return VideoListViewModel(mDataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}