package com.example.domain.repository

import com.example.domain.model.BooksListDomainModel

interface BooksRepository {
    suspend fun getBooksList(page: String): BooksListDomainModel
}