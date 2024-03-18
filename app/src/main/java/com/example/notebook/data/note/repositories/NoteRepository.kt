package com.example.notebook.data.note.repositories

import androidx.lifecycle.LiveData
import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.entities.Note
import com.example.notebook.data.note.interfaces.NoteRepositories

class NoteRepository(private val noteDao: NoteDao): NoteRepositories {

    private val notesAll by lazy {
        noteDao.readAllDate()
    }

    override suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

     override fun searchNotesByTitle(query: String): LiveData<List<Note>>{
        return noteDao.searchNotesByTitle(query)
    }

    override fun getAllNotes(): LiveData<List<Note>> = notesAll
}