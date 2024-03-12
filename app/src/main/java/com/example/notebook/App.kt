package com.example.notebook

import android.app.Application
import android.content.Context
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.note.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class App: Application() {

//    val noteDatabase: noteDa
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        database = AppDatabase.getInstance(this)
//    }
}