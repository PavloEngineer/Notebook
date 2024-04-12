package com.example.notebook.domain.use_cases

import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor (private val noteRepository: NoteRepository) {

    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}