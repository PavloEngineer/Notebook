package com.example.notebook.view.fragments.my_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notebook.domain.models.Note
import com.example.notebook.domain.use_cases.GetNotesUseCase
import com.example.notebook.domain.use_cases.SearchNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyNoteViewModel @Inject constructor(
    private val searchNoteUseCase: SearchNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase
): ViewModel() {

    private var _notes = getNotesUseCase.execute()

    val notes: LiveData<List<Note>> = _notes

    fun searchNotesByTitle(query: String): LiveData<List<Note>> {
        return searchNoteUseCase.execute(query)
    }

//    override fun onCleared() {
//        super.onCleared()
//        database.closeDatabase()
//    }
}