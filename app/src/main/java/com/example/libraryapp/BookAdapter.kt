package com.example.libraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.BookDomainModel

class BookAdapter(
    private val onBookClickListener: OnBookClickListener
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private val books = mutableListOf<BookDomainModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    fun setData(data: List<BookDomainModel>) {
        books.clear()
        books.addAll(data)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
    }

    interface OnBookClickListener {
        fun onBookClicked(bookId: String)
    }
}