package com.sematec.basic.room_practice

import com.sematec.basic.room.Book

interface BookContract {

    interface View {
        fun onBooks(books: List<Book>)
        fun onBookAdded()
        fun onBooksCleared()
    }
    interface Presenter {
        fun loadBooks()
        fun addBook(book: Book)
        fun bookAdded()
        fun onBooks(books: List<Book>)
        fun clearBooks()
        fun onBooksCleared()
    }
    interface Model {
        fun addBook(book: Book)
        fun getBooks()
        fun clearBooks()
    }

}