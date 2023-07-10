package com.example.codingchallengeapi.domain

import com.example.codingchallengeapi.domain.model.LaunchDetails
import com.example.codingchallengeapi.domain.model.ResultAPI

interface ILaunchDetailsGeneralRepository {
    suspend fun getSpecificResult(id: String): ResultAPI<LaunchDetails>

}
