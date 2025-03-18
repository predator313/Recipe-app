package com.example.composepaging3p1.domain

import com.example.composepaging3p1.data.remote.RecipeDto
import com.example.composepaging3p1.utils.networkUtils.NetworkResult
import retrofit2.Response

interface RecipeRepository {
    suspend fun getAllRecipe(page: Int, query: String): NetworkResult<RecipeDto>
}