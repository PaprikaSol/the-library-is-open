package com.example.libraryapp.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.useCase.BooksListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksListViewModel @Inject constructor(
    private val booksListUseCase: BooksListUseCase
) : ViewModel() {

    fun getBooksList() {
        viewModelScope.launch {
            val result = booksListUseCase(null).first()
            val booksList = result.booksList
            Log.d("CALL", "getBooksList: CALL!!")
        }
    }
}