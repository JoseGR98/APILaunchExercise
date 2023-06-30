package com.example.codingchallengeapi.domain

import com.example.codingchallengeapi.utils.ResultAPI

interface ILaunchGeneralRepository {

    suspend fun getResult(): ResultAPI<List<Launch>>

}
