package com.example.domain.model

import java.io.Serializable

data class BookDomainModel(
    val id: String,
    val title: String,
    val subject: String,
    val author: PersonDomainModel?
) : Serializable