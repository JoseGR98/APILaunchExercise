package com.example.codingchallengeapi.di

import com.example.codingchallengeapi.data.LaunchDetailsGeneralRepositoryImpl
import com.example.codingchallengeapi.data.LaunchGeneralRepositoryImpl
import com.example.codingchallengeapi.domain.ILaunchDetailsGeneralRepository
import com.example.codingchallengeapi.domain.ILaunchGeneralRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(implementation: LaunchGeneralRepositoryImpl): ILaunchGeneralRepository

    @Binds
    @Singleton
    abstract fun provideRepository2(implementation: LaunchDetailsGeneralRepositoryImpl): ILaunchDetailsGeneralRepository

}