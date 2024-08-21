package com.codexcue.takenotes.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.codexcue.takenotes.data.models.Note

@Dao
interface Dao {
    @Insert
    fun saveNote(note: Note)

    @Query("select * from notes")
    fun getAllNotes(): List<Note>

    @Query("delete from notes where id = :id")
    fun deleteNote(id: Int)
}