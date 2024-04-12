package com.example.notebook.data.note.repositories


import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.entities.NoteEntity
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) :
    NoteRepository {

    override suspend fun addNote(note: Note) {
        noteDao.addNote(NoteEntity.toNoteEntity(note))
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(NoteEntity.toNoteEntity(note))
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(NoteEntity.toNoteEntity(note))
    }

    override fun searchNotesByTitle(query: String): Flow<List<Note>> =
        noteDao.searchNotesByTitle(query).map { list ->
            list.map { it.toNote() }
        }


    override fun getAllNotes(): Flow<List<Note>> = noteDao.readAllDate().map { list ->
        list.map { it.toNote() }
    }
}