package com.example.notebook.di


import com.example.notebook.domain.repository.NoteRepository
import com.example.notebook.domain.use_cases.AddNoteUseCase
import com.example.notebook.domain.use_cases.DeleteNoteUseCase
import com.example.notebook.domain.use_cases.GetNotesUseCase
import com.example.notebook.domain.use_cases.SearchNoteUseCase
import com.example.notebook.domain.use_cases.UpdateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideAddNoteUseCase(noteRepository: NoteRepository) : AddNoteUseCase {
        return AddNoteUseCase(noteRepository)
    }

    @Provides
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository) : DeleteNoteUseCase {
        return DeleteNoteUseCase(noteRepository)
    }

    @Provides
    fun provideGetNotesUseCase(noteRepository: NoteRepository) : GetNotesUseCase {
        return GetNotesUseCase(noteRepository)
    }

    @Provides
    fun provideSearchNoteUseCase(noteRepository: NoteRepository) : SearchNoteUseCase {
        return SearchNoteUseCase(noteRepository)
    }

    @Provides
    fun provideUpdateNoteUseCase(noteRepository: NoteRepository) : UpdateNoteUseCase {
        return UpdateNoteUseCase(noteRepository)
    }
}