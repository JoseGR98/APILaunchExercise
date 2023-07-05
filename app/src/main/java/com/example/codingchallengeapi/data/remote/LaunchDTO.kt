package com.example.codingchallengeapi.data.remote

import com.google.gson.annotations.SerializedName

data class LaunchDTO(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("links")
    val links: Links?,
    @SerializedName("date_utc")
    val date_utc: String? = ""
) {
    val urlLogo : String
        get() = links?.patch?.small ?: ""
}
