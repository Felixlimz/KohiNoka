package com.dicoding.picodiploma.kohinoka.core.di

import android.content.Context
import com.dicoding.picodiploma.kohinoka.core.data.AppRepository
import com.dicoding.picodiploma.kohinoka.core.data.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): AppRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return AppRepository.getInstance(remoteDataSource)
    }
}