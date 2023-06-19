package com.example.data.model

import com.google.gson.annotations.SerializedName

class Book(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("subjects")
    val subjects: Array<String>,
    @SerializedName("authors")
    val authors: Array<Person>,
    @SerializedName("translators")
    val translators: Array<Person>,
    @SerializedName("bookshelves")
    val bookshelves: Array<String>,
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("copyright")
    val copyright: Boolean?,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("formats")
    val formats: Map<String, String>,
    @SerializedName("download_count")
    val downloadCount: Int
)