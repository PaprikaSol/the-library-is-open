package com.example.domain.useCase

import com.example.domain.model.BooksListDomainModel
import com.example.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BooksListUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {
    operator fun invoke(page: Int? = null, id: Int? = null): Flow<BooksListDomainModel> =
        booksRepository.getBooksList(page, id)
}