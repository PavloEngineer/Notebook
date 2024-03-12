package com.example.notebook.data.note.interfaces

import com.example.notebook.data.note.entities.Note

interface NoteRepositories {

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)
}