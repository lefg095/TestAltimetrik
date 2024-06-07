package com.example.myapplication.data

import retrofit2.http.GET

interface ApiService {

    @GET("photos/")
    suspend fun getPhotos(
    ): List<Photo>
}