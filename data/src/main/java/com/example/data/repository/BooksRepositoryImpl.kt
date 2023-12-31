package com.example.data.repository

import com.example.data.mapper.mapToDomain
import com.example.data.networking.GutendexService
import com.example.domain.model.BookDomainModel
import com.example.domain.model.BooksListDomainModel
import com.example.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val gutendexService: GutendexService
) : BooksRepository {
    override fun getBooksList(page: String?): Flow<BooksListDomainModel> = flow {
        val booksListDomainModel =
            gutendexService.getBooksList(page = page, ids = null).mapToDomain()
        emit(booksListDomainModel)
    }

    override fun getBookDetails(id: Int): Flow<BookDomainModel?> = flow {
        val response = gutendexService.getBooksList(page = null, ids = listOf(id)).mapToDomain()
        val bookDomainModel = response.booksList.firstOrNull()
        emit(bookDomainModel)
    }
}