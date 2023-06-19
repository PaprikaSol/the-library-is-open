package com.example.libraryapp.details

import com.example.domain.useCase.BookDetailsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.BookDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailsViewModel @Inject constructor(
    private val bookDetailsUseCase: BookDetailsUseCase
) : ViewModel() {

    private val _bookDetails = MutableStateFlow<BookDomainModel?>(null)
    val bookDetails = _bookDetails.asStateFlow()

    fun getBookDetails(bookId: Int) {
        viewModelScope.launch {
            bookDetailsUseCase(bookId).collect { result ->
                _bookDetails.update { result }
            }
        }
    }
}