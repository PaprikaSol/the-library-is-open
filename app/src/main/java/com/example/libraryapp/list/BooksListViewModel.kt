package com.example.libraryapp.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.BookDomainModel
import com.example.domain.model.PersonDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksListViewModel @Inject constructor(
//    private val booksListUseCase: BooksListUseCase
) : ViewModel() {

    fun getBooksList() {
        viewModelScope.launch {
//            val result = booksListUseCase(null).first()
//            val booksList = result.booksList
            getDummyData()
        }
    }

    fun getDummyData(): List<BookDomainModel> {
        val booksList = mutableListOf<BookDomainModel>()
        for (bookId in 1..3) {
                booksList.add(
                    BookDomainModel(
                        id = "$bookId",
                        title = "book$bookId",
                        subject = "subject$bookId",
                        author = PersonDomainModel(
                            name = "name$bookId",
                            lifeDuration = "lifeduration$bookId"
                        )
                    )
                )
        }
        Log.d("BooksList", "getBooksList: $booksList")
        return booksList
    }
}