package com.example.notebook.data.note.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.entities.NoteEntity
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao):
    NoteRepository {

    private val notesAll by lazy {
        noteDao.readAllDate()
    }

    override suspend fun addNote(note: Note) {
        noteDao.addNote(NoteEntity.toNoteEntity(note))
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(NoteEntity.toNoteEntity(note))
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(NoteEntity.toNoteEntity(note))
    }

     override fun searchNotesByTitle(query: String): LiveData<List<Note>>{
         val notesByTitle: List<Note>  = noteDao.searchNotesByTitle(query).value?.map {
             it.toNote()
         } ?: listOf()

         val liveData: MutableLiveData<List<Note>> = MutableLiveData()
         liveData.value = notesByTitle
         return liveData
    }

    override fun getAllNotes(): LiveData<List<Note>> {
        val allNotes = notesAll.value?.map {
            it.toNote()
        } ?: listOf()

        val liveData: MutableLiveData<List<Note>> = MutableLiveData()
        liveData.value = allNotes

        return liveData
    }
}