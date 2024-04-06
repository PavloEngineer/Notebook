package com.example.notebook.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor (private val noteRepository: NoteRepository) {

    fun invoke(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
}