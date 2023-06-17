package com.example.data.model

import com.google.gson.annotations.SerializedName

class Person(
    @SerializedName("birth_year")
    val birthYear: Int?,
    @SerializedName("death_year")
    val deathYear: Int?,
    @SerializedName("name")
    val name: String
)