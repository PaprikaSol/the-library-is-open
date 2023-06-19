package com.example.domain.useCase

import com.example.domain.model.BookDomainModel
import com.example.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookDetailsUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {
    operator fun invoke(id: Int): Flow<BookDomainModel?> =
        booksRepository.getBookDetails(id)
}