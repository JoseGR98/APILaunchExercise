package com.example.codingchallengeapi.data

import com.google.gson.annotations.SerializedName

data class Patch(
    @SerializedName("small")
    val small: String = ""
)