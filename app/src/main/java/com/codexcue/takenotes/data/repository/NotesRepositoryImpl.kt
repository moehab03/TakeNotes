package com.codexcue.takenotes.data.repository

import com.codexcue.takenotes.data.models.Note
import com.codexcue.takenotes.data.source.LocalDataSource
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(private val localDS: LocalDataSource) :
    NotesRepository {
    override suspend fun saveNote(note: Note) {
        localDS.saveNote(note)
    }

    override suspend fun getNotes(): List<Note> = localDS.getNotes()

    override suspend fun deleteNote(noteID: Int) {
        localDS.deleteNote(noteID)
    }

}