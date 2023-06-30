package com.example.codingchallengeapi.data

import com.google.gson.annotations.SerializedName

data class Flickr(
    @SerializedName("original")
    val small: List<String>,
)