package com.example.foody.util

sealed class NetworkResult<T> (
    val data: T? = null,
    val message: String? = null
        ){

}
