package com.example.notebook.view.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notebook.App
import com.example.notebook.data.entities.Note

class MyNoteViewModel: ViewModel() {

    private val _notes = App.noteRepository.notesAll
    val notes: LiveData<List<Note>> = _notes


//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            val list = mutableListOf<Note>()
//            list.add(Note(1, "Pavlo", "Nice"))
////            _notes.postValue(noteRepository.notesAll.value)
//        }
//    }
}