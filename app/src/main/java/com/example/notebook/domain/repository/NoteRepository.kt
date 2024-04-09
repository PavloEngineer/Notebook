package com.example.notebook.domain.repository

import androidx.lifecycle.LiveData
import com.example.notebook.domain.models.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    fun searchNotesByTitle(query: String): Flow<List<Note>>

    fun getAllNotes(): Flow<List<Note>>
}