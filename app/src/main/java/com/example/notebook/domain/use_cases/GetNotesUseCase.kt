package com.example.notebook.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    fun execute(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
}