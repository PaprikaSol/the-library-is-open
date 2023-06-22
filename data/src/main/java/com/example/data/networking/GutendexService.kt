package com.example.data.networking

import com.example.data.model.BooksListResponse
import com.example.data.networking.Urls.GET_BOOKS_LIST
import retrofit2.http.GET
import retrofit2.http.Query

interface GutendexService {
    @GET(GET_BOOKS_LIST)
    suspend fun getBooksList(
        @Query("page") page: String?,
        @Query("ids") ids: List<Int>?
    ): BooksListResponse
}