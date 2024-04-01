package com.example.notebook.data

import android.content.Context
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.note.repositories.NoteRepositoryImpl

// TODO: memory leak
object Repositories {

    private lateinit var applicationContext: Context

    private val database: NoteDatabase by lazy {
        NoteDatabase.initialDatabase(applicationContext)
    }

    val noteRepositoryImpl: NoteRepositoryImpl by lazy {
        NoteRepositoryImpl(database.getNoteDao())
    }

    fun init(context: Context) {
        applicationContext = context
    }

    fun closeDatabase() {
        database.close()
    }
}