package com.codexcue.takenotes.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codexcue.takenotes.data.models.Note
import com.codexcue.takenotes.data.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {
    val notesList = MutableLiveData<List<Note>>()

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val notes = repository.getNotes()
            notesList.postValue(notes)
        }
    }

    fun deleteNote(noteID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(noteID)
            getNotes()
        }
    }
}