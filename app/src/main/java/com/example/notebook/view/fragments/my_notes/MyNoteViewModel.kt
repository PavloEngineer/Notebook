package com.example.notebook.view.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.data.Repositories
import com.example.notebook.data.database.NoteDatabase
import com.example.notebook.data.note.entities.NoteEntity
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.use_cases.GetNotesUseCase
import com.example.notebook.domain.use_cases.SearchNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MyNoteViewModel @Inject constructor(
    private val database: NoteDatabase,
    private val searchNoteUseCase: SearchNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase
): ViewModel() {

    private var _notes = getNotesUseCase.execute()

    val notes: LiveData<List<Note>> = _notes

    fun searchNotesByTitle(query: String): LiveData<List<Note>> {
        return searchNoteUseCase.execute(query)
    }

    override fun onCleared() {
        super.onCleared()
        database.closeDatabase()
    }
}