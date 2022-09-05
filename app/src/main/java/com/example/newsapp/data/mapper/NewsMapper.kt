package com.example.newsapp.data.mapper

import com.example.newsapplication.data.model.ResultDTO
import com.google.gson.Gson
import okhttp3.ResponseBody

object NewsMapper {

    fun map(response: ResponseBody): ResultDTO {
        val responseStr = response.string()
        return Gson().fromJson(responseStr, ResultDTO::class.java)
    }
}