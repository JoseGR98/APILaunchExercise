package com.example.codingchallengeapi.data

import com.example.codingchallengeapi.data.remote.LaunchDTO
import com.example.codingchallengeapi.data.remote.LaunchDetailsDTO
import com.example.codingchallengeapi.domain.model.Launch
import com.example.codingchallengeapi.domain.model.LaunchDetails
import com.example.codingchallengeapi.domain.utils.formatDateUtils

fun LaunchDTO.toDomain(): Launch {

    return Launch(
        id = this.id ?: "",
        logo = this.urlLogo,
        title = this.name ?: "",
        time =  this.date_utc?.let { formatDateUtils(it) } ?: ""
    )
}

fun LaunchDetailsDTO.toDomain(): LaunchDetails {
    return LaunchDetails(
        id = this.id ?: "",
        logo = this.urlLogo,
        title = this.name ?: "",
        time = this.date_utc?.let { formatDateUtils(it) } ?: "",
        details = this.details ?: "",
        image = this.urlImage,
        gallery = this.urlGallery
    )
}

// TODO Change the LaunchDTO urlImage and insert it here