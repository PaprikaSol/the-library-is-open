package com.example.data.module

import com.example.data.networking.GutendexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val GUTENDEX_API_BASE_URL = "https://gutendex.com/"

    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(GUTENDEX_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun provideGutendexService(retrofit: Retrofit): GutendexService =
        retrofit.create(GutendexService::class.java)
}