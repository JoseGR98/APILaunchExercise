package com.example.codingchallengeapi.data.remote

import com.google.gson.annotations.SerializedName

data class FlickrDTO(
    @SerializedName("original")
    val small: List<String>,
)
