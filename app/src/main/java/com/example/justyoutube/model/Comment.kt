package com.example.justyoutube.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val comment: String,
    val commentByName: String,
    val commentId: Int
):Parcelable