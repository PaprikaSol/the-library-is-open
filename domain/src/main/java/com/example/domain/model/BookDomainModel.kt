package com.example.domain.model

data class BookDomainModel(
    val id: String,
    val title: String,
    val subject: String,
    val authors: List<PersonDomainModel>
)