package com.example.domain.useCase

import com.example.domain.repository.BooksRepository
import javax.inject.Inject

class BooksListUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {
    operator fun invoke(page: String) = booksRepository.getBooksList(page)
}