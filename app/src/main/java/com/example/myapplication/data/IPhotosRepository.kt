package com.example.myapplication.data

import kotlinx.coroutines.flow.Flow

interface IPhotosRepository {

    fun getPhotos() : Flow<DataState<BaseResponse<Photo>>>

}