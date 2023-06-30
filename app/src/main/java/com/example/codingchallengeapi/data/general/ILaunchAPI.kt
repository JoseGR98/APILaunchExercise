package com.example.codingchallengeapi.data.general

import com.example.codingchallengeapi.data.details.LaunchDetailsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ILaunchAPI {

    @GET("launches")
    suspend fun getElements(): Response<ArrayList<LaunchDTO>>

    @GET("launches/{id}")
    suspend fun getSpecificElement(@Path("id") id: String): Response<LaunchDetailsDTO>

}
