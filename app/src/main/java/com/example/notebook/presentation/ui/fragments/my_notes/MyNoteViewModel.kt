package com.example.notebook.presentation.ui.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.domain.use_cases.GetNotesUseCase
import com.example.notebook.domain.use_cases.SearchNoteUseCase
import com.example.notebook.presentation.ui.models.NoteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyNoteViewModel @Inject constructor(
    private val database: NoteDatabase,
    private val searchNoteUseCase: SearchNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase
): ViewModel() {

    private var _notes = getNotesUseCase.invoke().map { list -> list.map { NoteUI.toNoteUI(it) } }

    val notes: LiveData<List<NoteUI>> = _notes

    fun searchNotesByTitle(query: String): LiveData<List<NoteUI>> {
        return searchNoteUseCase.invoke(query).map { list -> list.map { NoteUI.toNoteUI(it) } }
    }

    override fun onCleared() {
        super.onCleared()
        database.close()
    }
}