package com.sematec.basic.room_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.R
import com.sematec.basic.room.Book
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity(), BookContract.View {

    lateinit var presenter: BookContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        presenter = BookPresenter(this)
        presenter.loadBooks()

        save.setOnClickListener {
            //validate form
            if (name.text.toString().isEmpty()) {
                name.error = "BookName is Mandatory"
                return@setOnClickListener
            }
            if (author.text.toString().isEmpty()) {
                author.error = "Author is Mandatory"
                return@setOnClickListener
            }
            if (genre.text.toString().isEmpty()) {
                genre.error = "Genre is Mandatory"
                return@setOnClickListener
            }
            presenter.addBook(
                Book(
                    id = System.currentTimeMillis().toInt(),
                    name = name.text.toString(),
                    author = author.text.toString(),
                    genre = genre.text.toString()
                )
            )


            clear.setOnClickListener {
                presenter.clearBooks()
            }

        }

    }

    override fun onBooks(books: List<Book>) {
       val adapter = BooksAdapter(this , books)
        bookList.adapter = adapter
    }

    override fun onBookAdded() {
    }

    override fun onBooksCleared() {
    }
}