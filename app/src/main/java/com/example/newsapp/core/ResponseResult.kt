package com.example.newsapp.core

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T?) : ResponseResult<T>()
    data class Error(val message: String, val code: Int = 0) : ResponseResult<Nothing>()
}
