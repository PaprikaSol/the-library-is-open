package com.example.domain.model

data class BooksListDomainModel(
    val nextPage: String?,
    val booksList: List<BookDomainModel>
)