package com.example.composepaging3p1.data.repository

import com.example.composepaging3p1.data.remote.RecipeApi
import com.example.composepaging3p1.data.remote.RecipeDto
import com.example.composepaging3p1.domain.RecipeRepository
import com.example.composepaging3p1.utils.AUTHORIZATION
import com.example.composepaging3p1.utils.QUERYB
import com.example.composepaging3p1.utils.networkUtils.NetworkResult
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepository {
    override suspend fun getAllRecipe(page: Int, query: String): NetworkResult<RecipeDto> {
        return try {
            val response = api.getAllRecipe(page = 1,
                query = QUERYB
            )
            if (response.isSuccessful) {
                Timber.tag("hello").e("success ${response.body()?.count}")
                response.body()?.let {
                    NetworkResult.Success(it)
                } ?: NetworkResult.Error("Empty response body")
            } else {
                NetworkResult.Error("Error: ${response.message()}")
            }
        } catch (e: Exception) {
            NetworkResult.Error("Exception: ${e.localizedMessage}")
        }
    }
}
