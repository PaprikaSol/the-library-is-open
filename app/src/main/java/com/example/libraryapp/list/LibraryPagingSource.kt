package com.example.libraryapp.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.BookDomainModel
import com.example.domain.useCase.BooksListUseCase
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LibraryPagingSource @Inject constructor(
    private val getBooksListUseCase: BooksListUseCase
) : PagingSource<String, BookDomainModel>() {
    override fun getRefreshKey(state: PagingState<String, BookDomainModel>): String? = null

    override suspend fun load(params: LoadParams<String>): LoadResult<String, BookDomainModel> {
        val nextKey = params.key
        val result = getBooksListUseCase(nextKey).first()
        val booksList = result.booksList

        return LoadResult.Page(
            data = booksList,
            prevKey = null,
            nextKey = result.nextPage
        )
    }
}
