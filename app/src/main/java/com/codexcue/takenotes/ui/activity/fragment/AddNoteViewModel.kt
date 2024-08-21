package com.codexcue.takenotes.ui.activity.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codexcue.takenotes.data.models.Note
import com.codexcue.takenotes.data.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {
    fun saveNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveNote(note)
        }
    }
}