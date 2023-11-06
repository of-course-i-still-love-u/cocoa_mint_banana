package com.example.justyoutube.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.justyoutube.R
import com.example.justyoutube.model.Youtube

class YoutubeItemAdapter(private val context:Context):ListAdapter<Youtube,YoutubeItemViewHolder>(YoutubeDiffUtil()) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    var onItemClick:((youtube:Youtube,context:Context)->Unit)? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_main_youtube_view,parent,false)
        return YoutubeItemViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: YoutubeItemViewHolder, position: Int) {
      val youtube = getItem(position)
        holder.initView(youtube,position)
        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            onItemClick?.invoke(youtube,context)
        }

    }

}