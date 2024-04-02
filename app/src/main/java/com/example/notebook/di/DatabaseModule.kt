package com.example.notebook.di

import android.content.Context
import androidx.room.Room
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.note.accessObjects.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private val NAME_DATABASE = "note_database"

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            NAME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.getNoteDao()
    }
}