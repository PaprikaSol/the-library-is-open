package com.example.domain.model

data class BookDomainModel(
    val id: Int,
    val title: String,
    val subject: String,
    val author: PersonDomainModel?
)