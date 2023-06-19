package com.example.domain.repository

import com.example.domain.model.BooksListDomainModel
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    fun getBooksList(page: Int?, id: Int?): Flow<BooksListDomainModel>
}