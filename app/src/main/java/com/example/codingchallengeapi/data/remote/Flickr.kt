package com.example.codingchallengeapi.data.remote

import com.google.gson.annotations.SerializedName

data class Flickr(
    @SerializedName("original")
    val small: List<String>,
)