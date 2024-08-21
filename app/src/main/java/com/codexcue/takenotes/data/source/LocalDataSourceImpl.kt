package com.codexcue.takenotes.data.source

import com.codexcue.takenotes.data.database.NotesDatabase
import com.codexcue.takenotes.data.models.Note
import javax.inject.Inject

class LocalDataSourceImpl
@Inject
constructor(private val database: NotesDatabase) :
    LocalDataSource {
    override suspend fun saveNote(note: Note) {
        database.dao().saveNote(note)
    }

    override suspend fun getNotes(): List<Note> = database.dao().getAllNotes()

    override suspend fun deleteNote(noteID: Int) {
        database.dao().deleteNote(noteID)
    }

}