package com.example.composepaging3p1.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepaging3p1.data.remote.RecipeItem

@Composable
fun RecipeItem(
    item: RecipeItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = item.title,
            fontSize = 16.sp,
        )
        Text(
            text = item.dateAdded,
            fontSize = 14.sp
        )
    }
}
