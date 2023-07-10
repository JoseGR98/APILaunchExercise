package com.example.codingchallengeapi.domain

import com.example.codingchallengeapi.domain.model.Launch
import com.example.codingchallengeapi.domain.model.ResultAPI

interface ILaunchGeneralRepository {
    suspend fun getResults(): ResultAPI<List<Launch>>

}
