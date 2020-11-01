package com.sematec.basic.room_practice

import com.sematec.basic.room.Book
import com.sematec.basic.utils.MyApplication

class BookModel(val presenter: BookContract.Presenter) : BookContract.Model {

    override fun addBook(book: Book) {
        MyApplication.roomDB.bookDAO().insertAll(book)
        presenter.bookAdded()
    }

    override fun getBooks() {
        presenter.onBooks(
            MyApplication.roomDB.bookDAO().getAll()
        )
    }

    override fun clearBooks() {
        MyApplication.roomDB.bookDAO().deleteAll()
        presenter.onBooksCleared()
    }

}