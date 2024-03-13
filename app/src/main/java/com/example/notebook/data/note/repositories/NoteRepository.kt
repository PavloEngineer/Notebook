package com.example.notebook.data.note.repositories

import androidx.lifecycle.LiveData
import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.entities.Note

class NoteRepository(private val noteDao: NoteDao) {

    private val notesAll by lazy {
        noteDao.readAllDate()
    }

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    fun getAllNotes(): LiveData<List<Note>> = notesAll
}