package com.example.myapplication.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
open class Photo(
    @Expose
    @SerializedName("albumId")
    var albumId: Int = 0,

    @Expose
    @SerializedName("id")
    var id: Int = 0,

    @Expose
    @SerializedName("title")
    var title: String = "",

    @Expose
    @SerializedName("url")
    var url: String = "",

    @Expose
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String = ""
) : Parcelable