package com.example.composepaging3p1.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RecipeApp: Application() {
    override fun onCreate() {
        super.onCreate()
            Timber.plant(Timber.DebugTree())
    }
}