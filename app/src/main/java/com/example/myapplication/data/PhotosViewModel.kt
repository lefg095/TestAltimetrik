package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel
@Inject
constructor(
    private val photoIPhotosRepository: IPhotosRepository
) : ViewModel () {


    private val _photoResponse = MutableLiveData<DataState<BaseResponse<Photo>>>()
    val photoResponse: LiveData<DataState<BaseResponse<Photo>>> get() = _photoResponse

    fun makeApiCall(photoStateEvent: PhotoStateEvent){
        when(photoStateEvent){
            is PhotoStateEvent.GetPhotos -> {
                viewModelScope.launch {
                    photoIPhotosRepository.getPhotos()
                        .collect {
                            _photoResponse.value = it
                        }
                }
            }
        }
    }
}