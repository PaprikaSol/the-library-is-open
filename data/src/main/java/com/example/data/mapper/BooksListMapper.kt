package com.example.data.mapper

import com.example.data.model.Book
import com.example.data.model.BooksListResponse
import com.example.data.model.Person
import com.example.domain.model.BookDomainModel
import com.example.domain.model.BooksListDomainModel
import com.example.domain.model.PersonDomainModel
import com.example.domain.utils.DateUtils
import com.example.domain.utils.NetworkingUtils.getNextPageNumberFromUri

fun BooksListResponse.mapToDomain() = BooksListDomainModel(
    nextPage = getNextPageNumberFromUri(next),
    booksList = results.map { it.mapToDomain() }
)

fun Book.mapToDomain() = BookDomainModel(
    id = id,
    title = title,
    subject = subjects.firstOrNull() ?: "",
    author = authors.firstOrNull()?.mapToDomain()
)

fun Person.mapToDomain() = PersonDomainModel(
    name = name,
    birthYear = DateUtils.formatYear(birthYear),
    deathYear = DateUtils.formatYear(deathYear)
)