package com.example.libraryapp.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.domain.useCase.BooksListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class BooksListViewModel @Inject constructor(
    private val booksListUseCase: BooksListUseCase
) : ViewModel() {

    private val pagingConfig = PagingConfig(
        pageSize = BOOKS_LIST_PAGE_SIZE,
        enablePlaceholders = false
    )

    fun getPagerFlow() = Pager(
        config = pagingConfig,
        pagingSourceFactory = { LibraryPagingSource(booksListUseCase) }
    ).flow.cachedIn(viewModelScope)
}

private const val BOOKS_LIST_PAGE_SIZE = 32