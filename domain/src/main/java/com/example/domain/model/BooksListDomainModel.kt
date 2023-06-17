package com.example.domain.model

data class BooksListDomainModel(
    val nextPage: Int?,
    val booksList: List<BookDomainModel>
)