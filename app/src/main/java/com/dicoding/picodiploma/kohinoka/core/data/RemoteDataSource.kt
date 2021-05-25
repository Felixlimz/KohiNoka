package com.dicoding.picodiploma.kohinoka.core.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.kohinoka.core.data.entity.ItemsItem
import com.dicoding.picodiploma.kohinoka.core.data.entity.ResponseYoutube
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance?: synchronized(this){
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getVideos(): LiveData<List<ItemsItem>> {
        val _videosList = MutableLiveData<List<ItemsItem>>()
        val client = ApiConfig.getApiService().getVideos()
        client.enqueue(object : Callback<ResponseYoutube> {
            override fun onResponse(call: Call<ResponseYoutube>, response: Response<ResponseYoutube>) {
                if(response.isSuccessful){
                    _videosList.value = response.body()!!.items
                } else{
                    Log.e("ERORO","LALALA")
                }
            }

            override fun onFailure(call: Call<ResponseYoutube>, t: Throwable) {
                Log.e("EROR", "RDS")
            }
        })
        return _videosList
    }
}