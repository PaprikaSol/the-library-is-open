package com.example.domain.repository

import com.example.domain.model.BookDomainModel
import com.example.domain.model.BooksListDomainModel
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    fun getBooksList(page: String?): Flow<BooksListDomainModel>
    fun getBookDetails(id: Int): Flow<BookDomainModel?>
}