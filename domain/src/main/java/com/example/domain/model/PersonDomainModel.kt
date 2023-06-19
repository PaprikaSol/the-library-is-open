package com.example.domain.model

import java.io.Serializable

data class PersonDomainModel(
    val birthYear: String,
    val deathYear: String,
    val name: String
): Serializable