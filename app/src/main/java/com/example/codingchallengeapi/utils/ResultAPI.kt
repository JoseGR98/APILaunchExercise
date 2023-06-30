package com.example.codingchallengeapi.utils

sealed class ResultAPI<T> {
    data class Success<T>(val data: T) : ResultAPI<T>()
    data class Error<T>(val message: String) : ResultAPI<T>()
}
