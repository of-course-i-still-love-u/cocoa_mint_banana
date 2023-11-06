package com.example.justyoutube.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Youtube(
    val avatarImage: String,
    val comments: List<Comment>,
    val id: String,
    val subtitle: String,
    val title: String,
    val youtubeImage: String,
    val youtubeUrl: String
):Parcelable