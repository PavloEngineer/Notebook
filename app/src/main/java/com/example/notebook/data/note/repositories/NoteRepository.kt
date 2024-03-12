package com.example.notebook.data.note.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.notebook.data.accessObjects.NoteDao
import com.example.notebook.data.note.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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