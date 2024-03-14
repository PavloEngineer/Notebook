package com.example.notebook.view.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.data.Repositories
import com.example.notebook.data.note.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyNoteViewModel: ViewModel() {

    private var _notes = Repositories.noteRepository.getAllNotes()

    val notes: LiveData<List<Note>> = _notes

    fun searchNotesByTitle(query: String): LiveData<List<Note>> {
        return Repositories.noteRepository.searchNotesByTitle(query)
    }
}