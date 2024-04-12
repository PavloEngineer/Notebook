package com.example.notebook.domain.use_cases

import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(title: String, text: String) {
        withContext(Dispatchers.IO) {
            noteRepository.addNote(Note(title = title, text = text))
        }
    }
}