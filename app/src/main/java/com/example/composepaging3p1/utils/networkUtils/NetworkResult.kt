package com.example.composepaging3p1.utils.networkUtils

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null,
) {
    data class Success<T>(val result: T) : NetworkResult<T>(result)
    data class Error<T>(val errorMessage: String) : NetworkResult<T>(message = errorMessage)
    data object Loading : NetworkResult<Nothing>()
}