package com.example.libraryapp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BooksListFragment : Fragment(R.layout.fragment_books_list),
    BooksViewHolder.OnBookClickListener {

    private val viewModel: BooksListViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var booksAdapter: BooksAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_books_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        booksAdapter = BooksAdapter(this)
        recyclerView.adapter = booksAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.getPagerFlow().collectLatest { pagingData ->
                booksAdapter.submitData(lifecycle, pagingData)
            }
        }
    }

    override fun onBookClicked(bookId: Int) {
        navigateToBookDetails(bookId)
    }

    private fun navigateToBookDetails(bookId: Int) {
        val action =
            BooksListFragmentDirections.actionBooksListFragmentToBookDetailsFragment(bookId)
        findNavController().navigate(action)
    }
}

