package com.example.codingchallengeapi.di

import com.example.codingchallengeapi.data.general.ILaunchAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val apiURL = "https://api.spacexdata.com/v5/"

    @Singleton
    @Provides
    fun getRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(apiURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetrofitService(retrofit: Retrofit): ILaunchAPI =
        retrofit.create(ILaunchAPI::class.java)

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .apply {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
        .build()
}
