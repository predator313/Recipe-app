package com.example.composepaging3p1.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composepaging3p1.data.remote.RecipeApi
import com.example.composepaging3p1.data.remote.RecipeDto
import com.example.composepaging3p1.data.remote.RecipeItem
import com.example.composepaging3p1.domain.RecipeRepository
import com.example.composepaging3p1.utils.QUERYB
import com.example.composepaging3p1.utils.networkUtils.NetworkResult

class RecipePagingSource(
    private val api: RecipeApi
): PagingSource<Int,RecipeItem>() {
    override fun getRefreshKey(state: PagingState<Int, RecipeItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeItem> {
        try {
           val pageNumber = params.key?:1
           val response = api.getAllRecipe(page = pageNumber, query = QUERYB)
               val result = response.body()!!.results
             return  LoadResult.Page(
                   data = result,
                   prevKey = if (pageNumber>1)pageNumber-1 else null,
                   nextKey = if(pageNumber >=6)null else pageNumber +1
               )

       }catch (e: Exception) {
          return LoadResult.Error(e)
       }
    }

}