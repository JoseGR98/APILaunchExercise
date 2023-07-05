package com.example.codingchallengeapi.data.remote

import com.google.gson.annotations.SerializedName

data class PatchDTO(
    @SerializedName("small")
    val small: String = ""
)
