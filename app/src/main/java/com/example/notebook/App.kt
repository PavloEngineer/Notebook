package com.example.notebook

import android.app.Application
import android.content.Context
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class App: Application() {

    companion object {

        lateinit var noteRepository: NoteRepository

        fun launchDatabase(context: Context) {
            runBlocking {
                launch(Dispatchers.IO) {
                    noteRepository = NoteRepository(NoteDatabase.getDatabase(context).getNoteDao())
                }
            }
        }
    }
}