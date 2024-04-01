package com.example.notebook.data.note.accessObjects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notebook.data.note.entities.NoteEntity

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    fun readAllDate(): LiveData<List<NoteEntity>>

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note WHERE title LIKE '%' || :query || '%'")
    fun searchNotesByTitle(query: String): LiveData<List<NoteEntity>>
}