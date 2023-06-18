package com.example.data.module

import com.example.data.networking.GutendexService
import com.example.data.repository.BooksRepositoryImpl
import com.example.domain.repository.BooksRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppRepositoryModule {

    @Provides
    fun provideBooksRepository(gutendexService: GutendexService): BooksRepository =
        BooksRepositoryImpl(gutendexService)

}