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
import androidx.lifecycle.lifecycleScope
import com.example.composepaging3p1.presentation.RecipeScreen
import com.example.composepaging3p1.presentation.RecipeViewModel
import com.example.composepaging3p1.ui.theme.ComposePaging3P1Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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

    override fun onStart() {
        super.onStart()
        Timber.tag("hello").e("onstart is called")
        startCoroutine()
        coroutinePractice()
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag("hello").e("on restart is called")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("hello").e("on pause is called")
        val mapp = mutableMapOf<String, String>()
        val mapp2 = hashMapOf<String, String>()

    }

    override fun onStop() {
        super.onStop()
        Timber.tag("hello").e("on stop is called")

    }

    private fun startCoroutine() {
        val myScope = CoroutineScope(Job())

        myScope.launch {
            delay(500L)
            Timber.tag("hello").e("A")

            coroutineScope {
                launch {
                    delay(1000L)
                    Timber.tag("hello").e("B")
                }

                delay(100L)
                Timber.tag("hello").e("C")
            }


            Timber.tag("hello").e("D")
        }
    }
    private fun coroutinePractice() {
        val myScope = CoroutineScope(Job())

//        lifecycleScope.launch {
        myScope.launch {
            Timber.tag("hello").e("first block")
            launch {
                delay(5000L)
                Timber.tag("hello").e("second block")
                delay(10000L)
            }
            Timber.tag("hello").e("third block")
        }
    }
}