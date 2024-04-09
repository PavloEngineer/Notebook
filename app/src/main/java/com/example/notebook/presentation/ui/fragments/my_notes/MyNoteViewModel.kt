package com.example.notebook.presentation.ui.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.domain.use_cases.GetNotesUseCase
import com.example.notebook.domain.use_cases.SearchNoteUseCase
import com.example.notebook.presentation.ui.models.NoteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyNoteViewModel @Inject constructor(
    private val database: NoteDatabase,
    private val searchNoteUseCase: SearchNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase
): ViewModel() {

    private val _allNotes = MutableStateFlow<List<NoteUI>>(emptyList())
    val allNotes: StateFlow<List<NoteUI>> = _allNotes

    init {
        takeAllNotes()
    }

    private fun takeAllNotes() {
        viewModelScope.launch {
            getNotesUseCase.invoke().collect { list ->
                _allNotes.value = list.map { NoteUI.toNoteUI(it) }
            }
        }
    }

    fun searchNotesByTitle(query: String): Flow<List<NoteUI>> {
        return searchNoteUseCase.invoke(query).map { list -> list.map { NoteUI.toNoteUI(it) } }
    }

    override fun onCleared() {
        super.onCleared()
        database.close()
    }
}