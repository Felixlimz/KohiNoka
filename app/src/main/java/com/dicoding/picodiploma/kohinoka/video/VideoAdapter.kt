package com.dicoding.picodiploma.kohinoka.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.kohinoka.core.data.entity.ItemsItem
import com.dicoding.picodiploma.kohinoka.databinding.VideoListRecyclerBinding

class VideoAdapter : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){

    private var listVideo = ArrayList<ItemsItem>()

    fun setVideos(videos: List<ItemsItem>){
        if(videos == null) return
        this.listVideo.clear()
        this.listVideo.addAll(videos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val videoListRecyclerBinding = VideoListRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(videoListRecyclerBinding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val videos = listVideo[position]
        holder.bind(videos)
    }

    override fun getItemCount(): Int {
        return listVideo.size
    }

    class VideoViewHolder(private val binding: VideoListRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(video : ItemsItem){
            with(binding){
                tvItemTitle.text = video.snippet.title
                tvItemSubtitle.text = video.snippet.channelTitle
                itemView.setOnClickListener{
                    //donothing
                }

                Glide.with(itemView.context)
                    .load(video.snippet.thumbnails.medium.url)
                    .into(ivItemImage)
            }
        }

    }
}