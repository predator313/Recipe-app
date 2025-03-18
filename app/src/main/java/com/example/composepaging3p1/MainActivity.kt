package com.example.composepaging3p1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composepaging3p1.presentation.RecipeScreen
import com.example.composepaging3p1.presentation.RecipeViewModel
import com.example.composepaging3p1.ui.theme.ComposePaging3P1Theme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        recipeViewModel.fetchAllRecipe()
        enableEdgeToEdge()
        setContent {
            ComposePaging3P1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   RecipeScreen(
                       modifier = Modifier.padding(innerPadding),
                       tangentialShowItemsPagingData = recipeViewModel.recipePagingData
                   )
                }

            }
        }
    }
}