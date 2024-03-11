package com.example.notebook.view.fragments.my_notes.details_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.App
import com.example.notebook.data.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsNoteViewModel: ViewModel(){

    private val noteRepository by lazy {
        App.noteRepository
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNote(note)
        }
    }
}