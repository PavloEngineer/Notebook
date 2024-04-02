package com.example.notebook.view.fragments.my_notes.creation_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.use_cases.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreationNoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
): ViewModel() {

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.execute(note)
        }
    }
}