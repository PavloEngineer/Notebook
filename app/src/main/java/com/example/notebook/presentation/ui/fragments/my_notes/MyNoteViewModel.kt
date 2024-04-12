package com.example.notebook.presentation.ui.fragments.my_notes

import androidx.lifecycle.ViewModel
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.domain.use_cases.GetNotesUseCase
import com.example.notebook.domain.use_cases.SearchNoteUseCase
import com.example.notebook.presentation.ui.models.NoteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MyNoteViewModel @Inject constructor(
    private val database: NoteDatabase,
    private val searchNoteUseCase: SearchNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase
): ViewModel() {

    private val _allNotes: Flow<List<NoteUI>> = getNotesUseCase().map { list -> list.map {NoteUI.toNoteUI(it) } }
    val allNotes: Flow<List<NoteUI>> = _allNotes

    fun searchNotesByTitle(query: String): Flow<List<NoteUI>> {
        return searchNoteUseCase(query).map { list -> list.map { NoteUI.toNoteUI(it) } }
    }

    override fun onCleared() {
        super.onCleared()
        database.close()
    }
}