package com.example.notebook.data.repositories

import android.util.Log
import com.example.notebook.data.accessObjects.NoteDao
import com.example.notebook.data.entities.Note
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

class NoteRepository(private val noteDao: NoteDao) {

    var notesAll = noteDao.readAllDate()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        Log.d("User index:", note.id.toString())
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}