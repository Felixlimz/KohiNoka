package com.dicoding.picodiploma.kohinoka.NokaPedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.kohinoka.databinding.ItemPediaBinding

class PediaAdapter : RecyclerView.Adapter<PediaAdapter.ListViewHolder>() {
    private var aContent = ArrayList<DataPedia>()
    private var onItemClickCallback : OnItemClickCallback? = null


    inner class ListViewHolder(private val connectingBinding : ItemPediaBinding): RecyclerView.ViewHolder(connectingBinding.root){
        fun bind(list : DataPedia){
            with(connectingBinding){
                tvTitle.text = list.title
                ivFoto.setImageResource(list.image)

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(list)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val contentBinding = ItemPediaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(contentBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(aContent[position])
    }

    override fun getItemCount(): Int = aContent.size

    fun setData (list: List<DataPedia>){
        this.aContent.clear()
        this.aContent.addAll(list)
        notifyDataSetChanged()
    }

    interface  OnItemClickCallback{
        fun onItemClicked(user : DataPedia)
    }
    fun setOnItemClickCallback (onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


}