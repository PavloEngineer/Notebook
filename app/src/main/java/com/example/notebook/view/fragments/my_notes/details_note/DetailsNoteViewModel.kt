package com.example.notebook.view.fragments.my_notes.details_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.App
import com.example.notebook.data.Repositories
import com.example.notebook.data.note.entities.Note
import com.example.notebook.data.note.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsNoteViewModel: ViewModel() {

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            Repositories.noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            Repositories.noteRepository.deleteNote(note)
        }
    }
}