package com.example.composepaging3p1.data.remote

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


data class RecipeDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    @SerializedName("results")
    val results: List<RecipeItem>,

)

@Keep
data class RecipeItem(
    val pk: Int,
    val title: String,
    val featuredImage: String,
    val ingredients: List<String>,
    @SerializedName("date_added") val dateAdded: String,

)
