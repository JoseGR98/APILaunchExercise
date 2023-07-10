package com.example.codingchallengeapi.domain.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDateUtils(
    date_UTC: String,
    iFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    oFormat: String = "dd MMM yyyy, HH:mm"
): String? {
    val inputFormat = SimpleDateFormat(iFormat, Locale.getDefault())
    val outputFormat = SimpleDateFormat(oFormat, Locale.getDefault())
    val date: Date? = date_UTC.let {
        inputFormat.parse(it)
    }
    return date?.let { outputFormat.format(it) }
}
