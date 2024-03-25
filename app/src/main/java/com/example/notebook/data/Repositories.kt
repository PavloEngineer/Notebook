package com.example.notebook.data

import android.content.Context
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.note.repositories.NoteRepository

// TODO: memory leak
object Repositories {

    private lateinit var applicationContext: Context

    private val database: NoteDatabase by lazy {
        NoteDatabase.initialDatabase(applicationContext)
    }

    val noteRepository: NoteRepository by lazy {
        NoteRepository(database.getNoteDao())
    }

    fun init(context: Context) {
        applicationContext = context
    }
}