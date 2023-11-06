package com.example.justyoutube.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.justyoutube.databinding.ItemMainYoutubeViewBinding
import com.example.justyoutube.model.Youtube

class YoutubeItemViewHolder(private val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val itemBinding get() = ItemMainYoutubeViewBinding.bind(itemView)
     fun initView(youtube: Youtube, position: Int) {
        itemBinding.itemMainYoutubeTextTitle.text = youtube.title
        itemBinding.itemMainYoutubeTextSubTitle.text = youtube.subtitle
        Glide.with(context).load(youtube.youtubeImage).into(itemBinding.itemMainYoutubeImageView)
         Glide.with(context).load(youtube.avatarImage).into(itemBinding.itemMainYoutubeImageAvatar)
    }
}