package com.example.notebook.data.note.interfaces

import androidx.lifecycle.LiveData
import com.example.notebook.data.note.entities.Note

interface NoteRepositories {

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    fun searchNotesByTitle(query: String): LiveData<List<Note>>

    fun getAllNotes(): LiveData<List<Note>>
}