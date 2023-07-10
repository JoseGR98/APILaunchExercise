package com.example.codingchallengeapi.data

import com.example.codingchallengeapi.data.core.ILaunchAPI
import com.example.codingchallengeapi.domain.ILaunchGeneralRepository
import com.example.codingchallengeapi.domain.model.Launch
import com.example.codingchallengeapi.domain.model.ResultAPI
import javax.inject.Inject

class LaunchGeneralRepositoryImpl @Inject constructor(private val retrofitService: ILaunchAPI) :
    ILaunchGeneralRepository {

    override suspend fun getResults(): ResultAPI<List<Launch>> {
        return try {
            ResultAPI.Success(
                retrofitService
                    .getElements()
                    .body()?.map {
                        it.toDomain()
                    }
                    ?: emptyList()
            )
        } catch (e: Exception) {
            ResultAPI.Error("Launches ResultAPI Error -> " + e.message.toString())
        }
    }
}
