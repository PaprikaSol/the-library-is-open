package com.example.libraryapp.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.libraryapp.R

class BookDetailsFragment : Fragment(R.layout.fragment_book_details) {

    private val args: BookDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookId = args.bookId
    }
}