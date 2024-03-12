package com.example.notebook.view.fragments.my_notes.adding_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.App
import com.example.notebook.data.Repositories
import com.example.notebook.data.note.entities.Note
import com.example.notebook.data.note.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddingNoteViewModel: ViewModel() {

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            Repositories.noteRepository.addNote(note)
        }
    }
}