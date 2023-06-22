package com.example.libraryapp.list

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.BookDomainModel
import com.example.libraryapp.R

class BooksViewHolder(
    itemView: View,
    private val onBookClickListener: OnBookClickListener
) : RecyclerView.ViewHolder(itemView) {
    private val cardView: CardView = itemView.findViewById(R.id.cardView)
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)

    fun bind(book: BookDomainModel) {
        cardView.setOnClickListener {
            onBookClickListener.onBookClicked(book.id)
        }
        titleTextView.text = book.title
        authorTextView.text = book.author?.name
    }

    interface OnBookClickListener {
        fun onBookClicked(bookId: Int)
    }
}
