package com.sematec.basic.room_practice

import com.sematec.basic.room.Book

class BookPresenter(val view:BookContract.View):BookContract.Presenter {

    lateinit var model:BookContract.Model
    init {
        model = BookModel(this)
    }

    override fun loadBooks() {
        model.getBooks()
    }

    override fun addBook(book: Book) {
        model.addBook(book)
    }

    override fun bookAdded() {
        model.getBooks()
    }

    override fun onBooks(books: List<Book>) {
        view.onBooks(books)
    }

    override fun clearBooks() {
        model.clearBooks()
    }

    override fun onBooksCleared() {
        model.getBooks()
    }
}