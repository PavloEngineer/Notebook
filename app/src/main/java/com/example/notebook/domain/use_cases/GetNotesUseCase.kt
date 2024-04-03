package com.example.notebook.domain.use_cases

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor (private val noteRepository: NoteRepository) {

    fun execute(): LiveData<List<Note>> {
        Log.d("Repository DATA", noteRepository.getAllNotes().value.toString())
        return noteRepository.getAllNotes()
    }
}