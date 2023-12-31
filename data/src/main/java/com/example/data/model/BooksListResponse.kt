package com.example.data.model

import com.google.gson.annotations.SerializedName

class BooksListResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: Array<Book>
)