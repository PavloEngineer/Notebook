package com.example.notebook.di

import com.example.notebook.data.note.repositories.NoteRepositoryImpl
import com.example.notebook.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNoteRepository(
        noteRepository: NoteRepositoryImpl
    ): NoteRepository
}