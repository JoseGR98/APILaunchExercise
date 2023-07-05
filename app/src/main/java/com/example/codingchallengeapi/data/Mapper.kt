package com.example.codingchallengeapi.data

import com.example.codingchallengeapi.data.remote.LaunchDetailsDTO
import com.example.codingchallengeapi.data.remote.LaunchDTO
import com.example.codingchallengeapi.domain.model.Launch
import com.example.codingchallengeapi.domain.model.LaunchDetails
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun LaunchDTO.toDomain(): Launch {

    return Launch(
        id = this.id ?: "",
        logo = this.urlLogo,
        title = this.name ?: "",
        time =  this.date_utc?.let { formatDate(it) } ?: ""
    )
}

fun LaunchDetailsDTO.toDomain(): LaunchDetails {
    return LaunchDetails(
        id = this.id ?: "",
        logo = this.urlLogo,
        title = this.name ?: "",
        time = this.date_utc?.let { formatDate(it) } ?: "",
        details = this.details ?: "",
        image = this.urlImage,
        gallery = this.urlGallery
    )
}

fun formatDate(date_UTC: String): String? {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
    val date: Date? = date_UTC.let {
        inputFormat.parse(it)
    }
    return date?.let { outputFormat.format(it) }
}