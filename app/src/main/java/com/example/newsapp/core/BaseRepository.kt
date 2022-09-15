package com.example.newsapp.core

import android.util.Log
import retrofit2.Response
import okhttp3.ResponseBody
import java.io.IOException

abstract class BaseRepository {

    suspend fun <T> wrapRequest(action: suspend () -> Response<T>): ResponseResult<T> {
        try {
            val response = action.invoke()
            Log.e("Repository", "Response from request: (${response.code()}) ${response.raw().request.url}")
            if (response.isSuccessful) {
                return ResponseResult.Success(response.body())
            } else {
                var errorText: String? = null
                try {
                    val errorBody: ResponseBody? = response.errorBody()
                    if (errorBody != null) {
                        errorText = errorBody.string()
                        Log.e("ResponseError", "Status: ${response.code()} errorString: $errorText")
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                errorText = errorText ?: response.message()
                return ResponseResult.Error(errorText!!, response.code())
            }
        } catch (e: Throwable) {
            Log.e("Repository Throwable", e.localizedMessage ?: "")
            return ResponseResult.Error(e.localizedMessage ?: "")
        }
    }
}