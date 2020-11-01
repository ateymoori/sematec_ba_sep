package com.sematec.basic.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDAO {
    @Query("SELECT * FROM book")
    fun getAll(): List<Book>

    @Query("SELECT * FROM book WHERE id IN (:bookID)")
    fun loadAllByIds(bookID: IntArray): List<Book>

    @Query("SELECT * FROM book WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Book

    @Query("DELETE FROM book")
    fun deleteAll()

    @Insert
    fun insertAll(vararg books: Book)

    @Delete
    fun delete(book: Book)

}