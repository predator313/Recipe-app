package com.example.composepaging3p1.data.remote

import com.squareup.moshi.JsonReader.Token
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/recipe/search")
//    @GET("quotes/")
   suspend fun getAllRecipe(
        @Query("page") page: Int,
        @Query("query") query: String,
    ): Response<RecipeDto>
}