package com.example.justyoutube.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseApiResponse<T> {

        @SerializedName("success")
        @Expose
        internal val success: Boolean = false

        @SerializedName("massage")
        @Expose
        internal val message: String = ""

        @SerializedName("statusCode")
        @Expose
        internal val statusCode: Int? = null

        @SerializedName("data")
        @Expose
        internal var data: T? = null
}