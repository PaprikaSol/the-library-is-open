package com.example.libraryapp.list

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.BookDomainModel

class BooksDiffCallback : DiffUtil.ItemCallback<BookDomainModel>() {
    override fun areItemsTheSame(oldItem: BookDomainModel, newItem: BookDomainModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: BookDomainModel, newItem: BookDomainModel): Boolean =
        oldItem == newItem
}