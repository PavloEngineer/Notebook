package com.example.notebook.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import javax.inject.Inject

class SearchNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun execute(query: String): LiveData<List<Note>> {
        return noteRepository.searchNotesByTitle(query)
    }
}