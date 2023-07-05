package com.example.codingchallengeapi.domain.model

data class LaunchDetails(
    val id: String,
    val logo: String,
    val title: String,
    val time: String,
    val details: String,
    val image: List<String>,
    val gallery: List<String>
)
