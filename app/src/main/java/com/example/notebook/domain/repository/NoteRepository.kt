package com.example.notebook.domain.repository

import androidx.lifecycle.LiveData
import com.example.notebook.domain.models.Note

interface NoteRepository {

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    fun searchNotesByTitle(query: String): LiveData<List<Note>>

    fun getAllNotes(): LiveData<List<Note>>
}