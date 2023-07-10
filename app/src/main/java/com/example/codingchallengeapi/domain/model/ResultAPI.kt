package com.example.codingchallengeapi.domain.model

sealed class ResultAPI<out T> {
    data class Success<T>(val data: T) : ResultAPI<T>()
    data class Error(val message: String) : ResultAPI<Nothing>()
}
