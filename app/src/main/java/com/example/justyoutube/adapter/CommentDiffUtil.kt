package com.example.justyoutube.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.justyoutube.model.Comment
import com.example.justyoutube.model.Youtube

class CommentDiffUtil : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem.commentId == newItem.commentId

}