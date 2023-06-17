package com.example.data.repository

import com.example.data.mapper.mapToDomain
import com.example.data.networking.GutendexService
import com.example.domain.model.BooksListDomainModel
import com.example.domain.repository.BooksRepository

class BooksRepositoryImpl(
    private val gutendexService: GutendexService
): BooksRepository {
    override suspend fun getBooksList(page: String): BooksListDomainModel =
        gutendexService.getBooksList(page).mapToDomain()

}