package com.dicoding.picodiploma.kohinoka.core.data

import com.dicoding.picodiploma.kohinoka.core.data.entity.ResponseYoutube
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("search?part=snippet&maxResults=25&q=petani%20kopi&key=AIzaSyAPkq_xK123aQCJd-WAD5V8buY0WeEaK1E")
    fun getVideos(): Call<ResponseYoutube>
}