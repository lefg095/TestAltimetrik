package com.example.myapplication.data

sealed class PhotoStateEvent {
    object  GetPhotos : PhotoStateEvent()
}