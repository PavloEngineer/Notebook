package com.example.notebook.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.note.accessObjects.NoteDao
import com.example.notebook.data.note.repositories.NoteRepositoryImpl
import com.example.notebook.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val NAME_DATABASE = "note_database"

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NAME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        val noteDao = noteDatabase.getNoteDao()
        Log.d("DatabaseModule", noteDatabase.isOpen.toString())
        return noteDao
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}