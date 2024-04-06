package com.example.notebook.presentation.ui.fragments.my_notes.details_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebook.domain.use_cases.DeleteNoteUseCase
import com.example.notebook.domain.use_cases.UpdateNoteUseCase
import com.example.notebook.presentation.ui.models.NoteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsNoteViewModel @Inject constructor(
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): ViewModel() {

    fun updateNote(noteUI: NoteUI) {
        viewModelScope.launch {
            updateNoteUseCase(noteUI.toNote())
        }
    }

    fun deleteNote(noteUI: NoteUI) {
        viewModelScope.launch {
            deleteNoteUseCase(noteUI.toNote())
        }
    }
}