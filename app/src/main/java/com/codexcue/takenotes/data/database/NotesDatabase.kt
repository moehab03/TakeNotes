package com.codexcue.takenotes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codexcue.takenotes.data.models.Note
import com.codexcue.takenotes.ui.utils.Const

@Database([Note::class], version = 4)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {

        private var database: NotesDatabase? = null

        fun initDataBase(context: Context) {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    Const.DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }

        fun getInstance(): NotesDatabase {
            return database!!
        }
    }
}