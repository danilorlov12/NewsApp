package com.example.newsapp.utils

fun String.parseDateToShortFormat(): String {
    val formattedDate = DateFormat.DATE.parse(this)
    return if (formattedDate != null) {
        DateFormat.ACT_TIME_SHORT.format(formattedDate)
    } else {
        ""
    }
}