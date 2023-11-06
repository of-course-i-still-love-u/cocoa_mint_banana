package com.example.justyoutube.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.justyoutube.databinding.ItemCommentYoutubeViewBinding
import com.example.justyoutube.model.Comment

class CommentItemViewHolder(private val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val itemBinding get() = ItemCommentYoutubeViewBinding.bind(itemView)
     fun initView(comment: Comment, position: Int) {
        itemBinding.itemCommentYoutubeTextCommentByName.text = comment.commentByName
        itemBinding.itemCommentYoutubeTextComment.text = comment.comment
    }
}