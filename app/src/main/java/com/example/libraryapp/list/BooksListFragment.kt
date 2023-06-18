package com.example.libraryapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.libraryapp.app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BooksListFragment : Fragment(R.layout.fragment_books_list) {

    private val viewModel: BooksListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_books_list, container, false)
        val btn = view.findViewById<Button>(R.id.btnNext)
        btn.setOnClickListener {
            navigateToBookDetails()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBooksList()
    }
    private fun navigateToBookDetails() {
        findNavController().navigate(R.id.action_booksListFragment_to_bookDetailsFragment)
    }
}