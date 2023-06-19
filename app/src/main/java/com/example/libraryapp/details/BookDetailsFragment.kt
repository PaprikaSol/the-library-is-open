package com.example.libraryapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.libraryapp.BookAdapter
import com.example.libraryapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailsFragment : Fragment(R.layout.fragment_book_details) {

    private val args: BookDetailsFragmentArgs by navArgs()

    private val viewModel: BookDetailsViewModel by viewModels()

    lateinit var bookTitle: TextView
    lateinit var authorName: TextView
    lateinit var authorLifeDuration: TextView
    lateinit var bookSubject: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_details, container, false)
        bookTitle = view.findViewById(R.id.titleTextView)
        authorName = view.findViewById(R.id.authorTextView)
        authorLifeDuration = view.findViewById(R.id.lifeDurationText)
        bookSubject = view.findViewById(R.id.subjectTextView)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookId = args.bookId
        viewModel.getBookDetails(bookId)

        lifecycleScope.launchWhenStarted {
            viewModel.bookDetails.collect { bookDomainModel ->
                bookTitle.text = bookDomainModel?.title
                authorName.text = bookDomainModel?.author?.name
                authorLifeDuration.text = bookDomainModel?.author?.lifeDuration
                bookSubject.text = bookDomainModel?.subject
            }
        }

    }
}