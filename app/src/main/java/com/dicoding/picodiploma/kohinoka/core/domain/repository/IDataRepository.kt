package com.dicoding.picodiploma.kohinoka.core.domain.repository

import androidx.lifecycle.LiveData
import com.bumptech.glide.load.engine.Resource
import com.dicoding.picodiploma.kohinoka.core.domain.model.Videos
import kotlinx.coroutines.flow.Flow

interface IDataRepository {
    fun getAllItems(): LiveData<Resource<List<Videos>>>
}