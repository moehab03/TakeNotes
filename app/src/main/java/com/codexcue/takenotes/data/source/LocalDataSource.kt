package com.codexcue.takenotes.data.source

import com.codexcue.takenotes.data.models.Note

interface LocalDataSource {
    suspend fun saveNote(note: Note)

    suspend fun getNotes(): List<Note>

    suspend fun deleteNote(noteID: Int)

}