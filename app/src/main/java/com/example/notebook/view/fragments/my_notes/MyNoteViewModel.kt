package com.example.notebook.view.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notebook.data.Repositories
import com.example.notebook.data.note.entities.Note

class MyNoteViewModel: ViewModel() {

    private val _notes = Repositories.noteRepository.getAllNotes()

    val notes: LiveData<List<Note>> = _notes
}