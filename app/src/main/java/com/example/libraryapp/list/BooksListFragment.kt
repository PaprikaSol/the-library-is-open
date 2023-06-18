package com.example.libraryapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.libraryapp.R
import com.example.libraryapp.databinding.FragmentBooksListBinding

class BooksListFragment : Fragment(R.layout.fragment_books_list) {

    private var _binding: FragmentBooksListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            navigateToBookDetails()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToBookDetails() {
        findNavController().navigate(R.id.action_booksListFragment_to_bookDetailsFragment)
    }
}