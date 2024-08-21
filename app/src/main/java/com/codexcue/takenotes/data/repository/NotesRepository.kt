package com.codexcue.takenotes.data.repository

import com.codexcue.takenotes.data.models.Note

interface NotesRepository {
    suspend fun saveNote(note: Note)

    suspend fun getNotes(): List<Note>

    suspend fun deleteNote(noteID: Int)

}