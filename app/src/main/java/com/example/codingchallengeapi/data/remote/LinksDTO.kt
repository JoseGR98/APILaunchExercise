package com.example.codingchallengeapi.data.remote

import com.google.gson.annotations.SerializedName

data class LinksDTO(
    @SerializedName("patch")
    val patch: PatchDTO?,

    @SerializedName("flickr")
    val flickr: FlickrDTO?
)
