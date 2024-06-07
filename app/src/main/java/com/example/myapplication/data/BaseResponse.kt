package com.example.myapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (

    @Expose
    @SerializedName("photoList")
    var photoList: List<T> = listOf()

)