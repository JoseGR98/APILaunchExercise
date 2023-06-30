package com.example.codingchallengeapi.data

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("patch")
    val patch: Patch?,
    @SerializedName("flickr")
    val flickr: Flickr?
)