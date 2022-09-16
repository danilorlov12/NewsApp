package com.example.newsapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {
    val DATE = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    val ACT_TIME_SHORT = SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH)
}