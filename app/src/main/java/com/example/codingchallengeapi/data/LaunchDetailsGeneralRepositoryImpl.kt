package com.example.codingchallengeapi.data

import com.example.codingchallengeapi.data.core.ILaunchAPI
import com.example.codingchallengeapi.domain.ILaunchDetailsGeneralRepository
import com.example.codingchallengeapi.domain.model.LaunchDetails
import com.example.codingchallengeapi.domain.model.ResultAPI
import javax.inject.Inject

class LaunchDetailsGeneralRepositoryImpl @Inject constructor(private val retrofitService: ILaunchAPI) :
    ILaunchDetailsGeneralRepository {

    override suspend fun getSpecificResult(id: String): ResultAPI<LaunchDetails> {
        return try {
            retrofitService
                .getSpecificElement(id = id)
                .body()?.toDomain()?.let {
                    ResultAPI.Success(it)
                } ?: ResultAPI.Error("Not found")
        } catch (e: Exception) {
            ResultAPI.Error("Launches Details ResultAPI Error -> " + e.message.toString())
        }
    }
    //Success/Failure with Coroutines
    suspend fun verifyReturnLaunch(id: String) {
        //coroutineExceptionHandler instead of runCatching
        runCatching {
            retrofitService
                .getSpecificElement(id = id)
                .body()!!.toDomain()
        }.onSuccess {
            ResultAPI.Success(it)
        }.onFailure {
            ResultAPI.Error(it.message ?: "Error generic")
        }
    }
}
