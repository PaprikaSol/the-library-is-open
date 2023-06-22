package com.example.libraryapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.domain.model.BookDomainModel
import com.example.libraryapp.R

class BooksAdapter(
    private val onBookClickListener: BooksViewHolder.OnBookClickListener
) : PagingDataAdapter<BookDomainModel, BooksViewHolder>(BooksDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(view, onBookClickListener)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}