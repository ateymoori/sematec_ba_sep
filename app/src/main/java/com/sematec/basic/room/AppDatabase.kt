package com.sematec.basic.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Book::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDAO(): BookDAO
}
