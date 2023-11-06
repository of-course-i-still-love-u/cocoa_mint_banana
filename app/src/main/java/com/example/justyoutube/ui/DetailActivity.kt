package com.example.justyoutube.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.justyoutube.adapter.CommentItemAdapter
import com.example.justyoutube.adapter.YoutubeItemAdapter
import com.example.justyoutube.databinding.ActivityDetailBinding
import com.example.justyoutube.model.Youtube

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private var commentItemAdapter: CommentItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        commentItemAdapter = CommentItemAdapter(this@DetailActivity)
        detailBinding.detailScreenRecyclerView.apply {
            adapter = commentItemAdapter
            layoutManager =
                LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
        }

        val payload = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("youtubeKey", Youtube::class.java)
        } else {
            intent.getParcelableExtra("youtubeKey")
        }

        payload?.let {
            commentItemAdapter?.submitList(it.comments)
            Log.d("TAG --->", "Data =" + it)
            Glide.with(this).load(it.youtubeImage).into(detailBinding.detailYoutubeImageView)
            detailBinding.detailYoutubeTextTitle.text = it.title
            detailBinding.detailYoutubeTextSubTitle.text = it.subtitle
        } ?: {
            Log.d("TAG --->", "Data = NULL")
        }
    }
}