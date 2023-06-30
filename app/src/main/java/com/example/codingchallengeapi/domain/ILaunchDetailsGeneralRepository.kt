package com.example.codingchallengeapi.domain

import com.example.codingchallengeapi.utils.ResultAPI

interface ILaunchDetailsGeneralRepository {

    suspend fun getSpecificResult(id: String): ResultAPI<LaunchDetails>

}