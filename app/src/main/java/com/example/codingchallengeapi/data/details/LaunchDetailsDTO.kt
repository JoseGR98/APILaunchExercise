package com.example.codingchallengeapi.data.details

import com.example.codingchallengeapi.data.Links
import com.google.gson.annotations.SerializedName

data class LaunchDetailsDTO(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("links")
    val links: Links?,
    @SerializedName("date_utc")
    val date_utc: String? = "",
    @SerializedName("details")
    val details: String? = ""
) {
    val urlLogo : String
        get() = links?.patch?.small ?: ""
    val urlImage: List<String>
        get() = links?.flickr?.small ?: emptyList()
    val urlGallery : List<String>
        get() = links?.flickr?.small ?: emptyList()
}