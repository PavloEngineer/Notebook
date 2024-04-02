package com.example.notebook.domain.use_cases

import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    suspend fun execute(note: Note) {
        noteRepository.addNote(note)
    }
}