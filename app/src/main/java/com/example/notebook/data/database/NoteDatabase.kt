package com.example.notebook.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
}