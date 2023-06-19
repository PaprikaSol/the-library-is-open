package com.example.libraryapp.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.BookDomainModel
import com.example.domain.useCase.BooksListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksListViewModel @Inject constructor(
    private val booksListUseCase: BooksListUseCase
) : ViewModel() {

    private val _booksList = MutableStateFlow<List<BookDomainModel>>(listOf())
    val booksList = _booksList.asStateFlow()

    fun getBooksList() {
        viewModelScope.launch {
            booksListUseCase().collect { result ->
                _booksList.update { result.booksList }
            }
        }
    }
}