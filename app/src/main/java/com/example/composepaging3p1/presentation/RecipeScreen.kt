package com.example.composepaging3p1.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.composepaging3p1.data.remote.RecipeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    tangentialShowItemsPagingData:Flow<PagingData<RecipeItem>>
) {
    val tangentialShowItems = tangentialShowItemsPagingData.collectAsLazyPagingItems(context = Dispatchers.IO)

    if (tangentialShowItems.itemCount == 0 && tangentialShowItems.loadState.refresh == LoadState.Loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            FullScreenLoader(modifier = Modifier.size(100.dp))
        }
    } else {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(count = tangentialShowItems.itemCount) { index ->
                tangentialShowItems[index]?.let { relatedItem ->
                    RecipeItem(
                        item = relatedItem,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}