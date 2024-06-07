package com.example.myapplication.data

import com.example.myapplication.data.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PhotosRepository(
    private val apiService: ApiService
) : IPhotosRepository {

    override fun getPhotos(): Flow<DataState<BaseResponse<Photo>>> = flow {
        emit(DataState.Loading("Cargando elementos..."))
        try{
            val response = apiService.getPhotos()
            val baseResponse = BaseResponse((response))
            emit(DataState.Success(baseResponse))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
}