package com.example.notebook.domain.use_cases

import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    operator fun invoke(query: String): Flow<List<Note>> {
        return noteRepository.searchNotesByTitle(query)
    }
}