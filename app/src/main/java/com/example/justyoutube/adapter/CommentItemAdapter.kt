package com.example.justyoutube.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.justyoutube.R
import com.example.justyoutube.model.Comment

class CommentItemAdapter(private val context:Context):ListAdapter<Comment,CommentItemViewHolder>(CommentDiffUtil()) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_comment_youtube_view,parent,false)
        return CommentItemViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: CommentItemViewHolder, position: Int) {
      val comment = getItem(position)
        holder.initView(comment,position)


    }

}