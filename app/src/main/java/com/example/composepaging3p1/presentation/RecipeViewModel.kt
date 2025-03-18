package com.example.composepaging3p1.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.composepaging3p1.data.remote.Repository
import com.example.composepaging3p1.domain.RecipeRepository
import com.example.composepaging3p1.utils.networkUtils.NetworkResult
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: Repository
) : ViewModel() {

    fun fetchAllRecipe() {
//        viewModelScope.launch {
//            when (val response = recipeRepository.getAllRecipe()) {
//                is NetworkResult.Success -> {
//                    Timber.tag("hello").e("response ${response.result}")
//                }
//                is NetworkResult.Error -> {
//                    Timber.tag("hello").e("api Error ${response.errorMessage}")
//                }
//                else -> Timber.tag("hello").e("loading")
//            }
//        }
    }
    val recipePagingData = recipeRepository.getAllRecipe().cachedIn(viewModelScope)
}
