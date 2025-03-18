package com.example.composepaging3p1.di

import com.example.composepaging3p1.data.remote.RecipeApi
import com.example.composepaging3p1.data.remote.Repository
import com.example.composepaging3p1.data.repository.RecipeRepositoryImpl
import com.example.composepaging3p1.domain.RecipeRepository
import com.example.composepaging3p1.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Token 9c8b06d329136da358c2d00e76946b0111ce2c48")
                    .build()
                chain.proceed(request)
            }
            .build()
    }
    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): RecipeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(api: RecipeApi): RecipeRepository {
        return RecipeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRepo(api: RecipeApi): Repository {
        return Repository(api)
    }
}