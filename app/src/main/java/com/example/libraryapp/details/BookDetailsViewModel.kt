package com.example.libraryapp.details

import androidx.lifecycle.ViewModel
import com.example.domain.model.BookDomainModel
import com.example.domain.model.PersonDomainModel

class BookDetailsViewModel : ViewModel() {
    fun getDummyDetailsData() =
        BookDomainModel(
            id = "id",
            subject = "subject",
            title = "title",
            author = PersonDomainModel(
                name = "author name",
                lifeDuration = "2000-2003"
            )
        )
}