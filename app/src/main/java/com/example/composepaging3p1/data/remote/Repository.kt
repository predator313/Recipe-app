package com.example.composepaging3p1.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.composepaging3p1.data.remote.paging.RecipePagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val api: RecipeApi) {
    fun getAllRecipe() = Pager(
        config = PagingConfig(
            pageSize = 30,
            maxSize = 150,

        ),
        pagingSourceFactory = {RecipePagingSource(api)}
    ).flow.flowOn(Dispatchers.IO)
}