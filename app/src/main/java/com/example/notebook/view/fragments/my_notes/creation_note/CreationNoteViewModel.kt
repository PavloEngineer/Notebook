package com.example.notebook.view.fragments.my_notes.creation_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.data.Repositories
import com.example.notebook.data.note.entities.NoteEntity
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.use_cases.AddNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreationNoteViewModel(
    private val addNoteUseCase: AddNoteUseCase
): ViewModel() {

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.execute(note)
        }
    }
}